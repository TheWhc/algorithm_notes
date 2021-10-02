package 并发.生产者和消费者问题.wait和notify;

import java.util.Random;
import java.util.Vector;

/**
 * @ClassName: Consumer
 * @Author: whc
 * @Date: 2021/10/01/14:18
 */
public class Consumer implements Runnable{

	private final Vector sharedQueue; // 内存缓冲区
	private final int SIZE; // 缓冲区大小
	private static final int SLEEPTIME = 1000;

	public Consumer(Vector sharedQueue, int SIZE) {
		this.sharedQueue = sharedQueue;
		this.SIZE = SIZE;
	}

	@Override
	public void run() {
		Random r = new Random();

		System.out.println("start consumer id = " + Thread.currentThread().getId());

		try {
			while (true) {
				// 模拟延迟
				Thread.sleep(r.nextInt(SLEEPTIME));

				// 当队列空时阻塞等待
				while(sharedQueue.isEmpty()) {
					synchronized (sharedQueue) {
						System.out.println("Queue is empty, consumer" + Thread.currentThread().getId()
						 + " is waiting, size:" + sharedQueue.size());
						sharedQueue.wait();
					}
				}

				// 队列不为空时持续消费元素
				synchronized (sharedQueue) {
					System.out.println("consumer consume data:" + sharedQueue.remove(0) +  ", size:" + sharedQueue.size());
					sharedQueue.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupted();
		}
	}
}
