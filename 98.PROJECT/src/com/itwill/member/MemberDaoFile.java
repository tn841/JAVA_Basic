package com.itwill.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/*
 * DAO(Data Access Object)
 * 	 - �������Ÿ�� �����ϰ��ִ� ����(���̺�)��
 *     CRUD(Create,Read,Update,Delete) �۾����Ҽ��ִ�
 *     �����޽�带 �������ִ� Ŭ����
 *   - MemberService�� ��û(ȣ��)���޾Ƽ� Data Accessing(File)��
 *     ���õ� �������(insert,select,update,delete �޽��) 
 *     �� �����ϴ°�ü
 */
public class MemberDaoFile implements MemberDao {
	
	private File memberFile;
	
	public MemberDaoFile()throws Exception {
		
		
		memberFile=new File("member.dat");
		if(!memberFile.exists()){
			memberFile.createNewFile();
			ObjectOutputStream oos=
					new ObjectOutputStream(
							new FileOutputStream(memberFile));
			oos.writeObject(new ArrayList<Member>());
			oos.close();
		}
	}
	/*
	 * �����б�(����)
	 */
	private ArrayList<Member> readData() throws Exception{
		ObjectInputStream ois=
				new ObjectInputStream(
						new FileInputStream(memberFile));
		ArrayList<Member> memberList=
				(ArrayList<Member>)ois.readObject();
		return memberList;
	}
	/*
	 * ���Ͼ���(��������)
	 */
	private void saveData(ArrayList<Member> memberList)throws Exception{
		ObjectOutputStream oos=
				new ObjectOutputStream(
						new FileOutputStream(memberFile));
		oos.writeObject(memberList);
		oos.flush();
		oos.close();
	}
	
	/*
	 * insert(create)
	 */
	/* (non-Javadoc)
	 * @see com.itwill.member.MemberDao#insert(com.itwill.member.Member)
	 */
	@Override
	public void insert(Member addMember)throws Exception{
		System.out.println("3.MemberDao insert");
		ArrayList<Member> memberList=(ArrayList<Member>)this.readData();
		memberList.add(addMember);
		saveData(memberList);
	}
	/*
	 * select(read): ��� 1�� select
	 */
	/* (non-Javadoc)
	 * @see com.itwill.member.MemberDao#selectById(java.lang.String)
	 */
	@Override
	public Member selectById(String id) throws Exception{
		System.out.println("3.MemberDao selectById");
		ArrayList<Member> memberList=this.readData();
		Member findMember=null;
		for (Member member : memberList) {
			if(member.getId().equals(id)){
				findMember=member;
				break;
			}
		}
		return findMember;
	}
	/*
	 * select(read): ��� ������ select
	 */
	/* (non-Javadoc)
	 * @see com.itwill.member.MemberDao#selectAll()
	 */
	@Override
	public ArrayList<Member> selectAll() throws Exception{
		System.out.println("3.MemberDao selectAll");
		ArrayList<Member> memberList=readData();
		return memberList;
	}
	/*
	 * update 
	 */
	/* (non-Javadoc)
	 * @see com.itwill.member.MemberDao#update(com.itwill.member.Member)
	 */
	@Override
	public void update(Member updateMember){
		System.out.println("3.MemberDao update");
	}
	/*
	 * delete
	 */
	/* (non-Javadoc)
	 * @see com.itwill.member.MemberDao#deleteById(java.lang.String)
	 */
	@Override
	public void deleteById(String id) throws Exception{
		ArrayList<Member> memberList=
				(ArrayList<Member>)readData();
		for (Member member : memberList) {
			if(member.getId().equals(id)){
				memberList.remove(member);
				break;
			}
		}
		saveData(memberList);
	}
}









