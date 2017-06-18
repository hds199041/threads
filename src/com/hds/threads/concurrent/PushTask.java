package com.hds.threads.concurrent;

public class PushTask implements Runnable{
	public volatile static long t=0;

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
