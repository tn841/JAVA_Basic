
public class AcademyMember {
	public int no;
	public String name;
	
	public AcademyMember() {
		// TODO Auto-generated constructor stub
	}

	public AcademyMember(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public void print(){
		System.out.print(no+"\t"+name+"\t");
	}
	
	//getter, setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
