package test;

import java.io.IOException;

public class TestThread implements Runnable {
	private static boolean n=true;
	private static boolean flag=false;


		@Override
		public  void run() {
			// TODO Auto-generated method stub
			while(n) {
				try {
					print();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
				
		}
		
		public synchronized void print() throws InterruptedException {
			if(Thread.currentThread().getName().equals("A")) {
				if(flag) {
					wait();
				}else {
					flag=true;
					System.out.println("AAAAAAAA");
				} 
				notify();
			}else {
				if(!flag) {
					wait();
				}else {
					flag=false;
					System.out.println("BBBBBBBB");
				}
				notify();
			}
			
			
		}
		
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*System.out.println("input a number:");
		Scanner sc=new Scanner(System.in);
		double a=sc.nextDouble();
		System.out.println("the input number is "+a);
		double b = Math.sqrt(a);
		System.out.println("the input sqrt is "+b);
		double c = Math.pow(a, 2);
		System.out.println("the input pow for 2 is "+c);
		System.out.println("the max number of 2 is "+Math.max(a, b));
		System.out.println("the abs of the number is "+Math.abs(-100));
		System.out.println("the random number is "+Math.round(Math.random()*100));
		System.out.println("the random number is "+Math.random()*100);
		int ss=System.in.read();
		System.out.println(ss);
		sc.close();*/
		TestThread b=new TestThread();
		Thread b1=new Thread(b);
		Thread b2=new Thread(b);
		
		b1.setName("A");
		b2.setName("B");
		
		b1.start();
		b2.start();

	}


	
	


}
