/*
추상클래스
  1.정의: 하나이상의 추상메소드가 정의되어있는 클래스
     ex> public abstract class Test{
         	//추상메쏘드();
         	public abstract int print(int i);
         	//일반메쏘드();
         	public void test(){
         	}
         }
         ==>추상메쏘드: 메쏘드의 구현부분이 없고 원형(prototype)만 존재하는 메쏘드
            ex> public abstarct int print(int i);          
               
  2. 추상클래스는 불완전한 추상메쏘드를 가지므로 객체생성이 불가능하다.
      Test t=new Test();(X)
      
  3. 추상클래스는 추상클래스를 상속받아서 추상메쏘드를 
     구현(오버라이딩)하는 자식 클래스를 만들어 사용(객체생성)해야한다 
*/

public abstract class AbstractParent {	//하나 이상의 추상메소드가 구현된 추상 클래스.
	public void method1(){
		System.out.println("구현된 메소드");
	}
	
	public abstract void method2();	//추상 메소드
	
}
