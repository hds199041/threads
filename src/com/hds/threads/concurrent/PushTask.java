package com.hds.threads.concurrent;

/**
 * 2017-0619 volatile还没解决可见性问题.
 * @author john
 *
 */
public class PushTask implements Runnable{
	public volatile static Long t=0L;

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			t++;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] threads=new Thread[10];
		for(int i=0;i<10;i++){
			threads[i]=new Thread(new PushTask());
			threads[i].start();
		}
		
		for(int i=0;i<10;i++){
			threads[i].join();
		}
	
		System.out.println("t===="+t);
	}
	
	
}
