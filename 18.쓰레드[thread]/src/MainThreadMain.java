/*
쓰레드: 
   - 프로그램코드를 실행시키는 힘 
   - 메인쓰레드,AWT 쓰레드,사용자정의 쓰레드
   - 언제 만드냐--> 두가지일을 동시에 해야할때..
 
 
- 사용자 정의 쓰레드객체 만드는 방법(형식)
     

		type A:
	1. Thread 클래스를 상속받는다.
	2. Thread class의 run method를 overriding 한다.
		동사원형:public void run()
	3. Thread 객체를 생성한다.
	4. Thread를 시작시킨다.
	
    	type B:
	1. Runnable interface를 implements 한다.
	2. Runnable interface를 implements 한객체를 Thread 클래스의 생성자에 넣어서 Thread 객체를 생성한다
   	3. Thread 를 시작시킨다.

   형식>>
    1. Thread 클래스를 상속받아서 만든다..
      ex> class ThreadEx extends Thread{
          		// run 메쏘드를 재정의 해야한다.
          		 public void run(){
          		 	//사용자가만든 쓰레드 가 실행할코드
          		 }
          } 
    2. Runnable interface를 implements 해서만든다
      ex>  class ThreadImpl implements Runnable{
           		public void run(){
          		 }
           } 

*/
public class MainThreadMain {

	public static void main(String[] args) {
		Thread cThread = Thread.currentThread();	//정적 메소드, 반환타입이 Thread, 이태릭체 -> 추상 메소드 
		String cThreadName = cThread.getName();
		System.out.println("현재 쓰레드 이름 : "+cThreadName);
		MainThreadCalled mtc = new MainThreadCalled();
		System.out.println("1. main 쓰레드");
		mtc.main_called_method();
		System.out.println("2. main 쓰레드");
	}

}
