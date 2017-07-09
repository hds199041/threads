package com.hds.threads.concurrent;
import java.util.concurrent.atomic.AtomicLong;
/**
 * 2017-0619 volatile还没解决可见性问题.
 * @author john
 *
 */
public class PushTask implements Runnable{
	public static AtomicLong t=new AtomicLong();
	//public volatile static Long t=0L;
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			t.incrementAndGet();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		long start =System.currentTimeMillis();
		Thread[] threads=new Thread[30];
		for(int i=0;i<30;i++){
			threads[i]=new Thread(new PushTask());
			threads[i].start();
		}
		
		for(int i=0;i<30;i++){
			threads[i].join();
		}
	
		System.out.println("t===="+t.get());
		long end=System.currentTimeMillis()-start;
		System.out.println("用了"+end);
	}
	
	
}
