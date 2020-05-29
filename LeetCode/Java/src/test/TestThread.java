package test;

import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public  class  TestThread implements Runnable {
	private volatile static boolean n=true;
	private volatile static boolean flag=false;
	private volatile static boolean A = true;
	private volatile static boolean B = false;
	private volatile  Semaphore spA;
	private volatile  Semaphore spB;


		@Override
		public  void run() {
			// TODO Auto-generated method stub
			while (n) {
				try {
					printA();
					printB();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	private TestThread(){
		spA = new Semaphore(1);
		spB = new Semaphore(0);
	}


	private synchronized void print() throws InterruptedException {
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

	private synchronized void print_v1() throws InterruptedException {
		if(Thread.currentThread().getName().equals("A")) {
			if(!flag) {
				System.out.println("AAAAAAAA");
				flag=true;
			}
		}else {
			if(flag) {
				System.out.println("BBBBBBBB");
				flag=false;
			}
		}
	}

	private  void print_v2() throws InterruptedException {
		if(Thread.currentThread().getName().equals("A")) {
			while(true){
				if(A){
					B = false;
					System.out.println("AAAAAAAA");
					A = false;
					B = true;
				}
			}

		}else {
			while(true){
				if (B) {
					A = false;
					System.out.println("BBBBBBBB");
					B = false;
					A = true;
				}
			}

		}
	}

	private void print_v3() throws InterruptedException {
		if(Thread.currentThread().getName().equals("A")) {
			spA.acquire();
			System.out.println("AAAAAAAAA");
			spB.release();
		}else {
			spB.acquire();
			System.out.println("BBBBBBBB");
			spA.release();
		}
	}

	private  void printA()throws InterruptedException {
		spA.acquire();
		System.out.println("AAAAAAAAA");
		spB.release();
	}

	private  void printB()throws InterruptedException {
		spB.acquire();
		System.out.println("BBBBBBBB");
		spA.release();
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

        AtomicInteger ai = new AtomicInteger(0);
		Lock lk = new ReentrantLock();
		ReadWriteLock lk1 = new ReentrantReadWriteLock();
		//lk1.readLock();

	}

	public void testTime(){
		Time time = new Time(System.currentTimeMillis());
		time.toString();

	}


	
	


}
