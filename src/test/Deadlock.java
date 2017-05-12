package test;

public class Deadlock {
	public static void main(String[] args){
		final A a = new A();
		final B b = new B();
		Thread t1 = new Thread (new Runnable() {
			public void run() {
				a.hello(b);
			}
		});
		Thread t2 = new Thread (new Runnable() {
			public void run() {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				b.hello(a);
			}
		});
		t1.start();
		t2.start();
	}
	
	public static class A{
		public synchronized void hello(B b){
			System.out.println("Waiting for B");
			b.appear();
		}
		
		public synchronized void appear(){
			System.out.println("A has appeared");
		}
	}
	
	public static class B{
		public synchronized void hello(A a){
			System.out.println("Waiting for A");
			a.appear();
		}
		
		public synchronized void appear(){
			System.out.println("B has appeared");
		}
	}
}
