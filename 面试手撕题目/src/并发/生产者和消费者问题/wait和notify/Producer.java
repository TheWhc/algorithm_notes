package 并发.生产者和消费者问题.wait和notify;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: Producer
 * @Author: whc
 * @Date: 2021/10/01/14:07
 */
public class Producer implements Runnable {

	private volatile boolean isRunning = true;
	private final Vector sharedQueue;   // 内存缓冲区
	private final int SIZE;   // 缓冲区大小
	private static AtomicInteger count = new AtomicInteger(); // 总数,原子操作
	private static final int SLEEPTIME = 1000;

	public Producer(Vector sharedQueue, int SIZE) {
		this.sharedQueue = sharedQueue;
		this.SIZE = SIZE;
	}

	@Override
	public void run() {
		int data;
		Random r = new Random();

		System.out.println("start producer id = " + Thread.currentThread().getId());

		try {
			while(isRunning) {
				// 模拟延迟
				Thread.sleep(r.nextInt(SLEEPTIME));

				// 当队列满时阻塞等待
				while(sharedQueue.size() == SIZE) {
					synchronized (sharedQueue) {
						System.out.println("Queue is full, producer" + Thread.currentThread().getId()
						 + " is waiting, size:" + sharedQueue.size());
						sharedQueue.wait();
					}
				}

				// 队列不满时持续创建新元素
				synchronized (sharedQueue) {
					data = count.incrementAndGet();
					sharedQueue.add(data);
					System.out.println("producer create data:" + data + ", size:" + sharedQueue.size());
					sharedQueue.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			// 测试当前线程是否被中断
			Thread.currentThread().interrupted();
		}
	}

	public void stop() {
		isRunning = false;
	}
}
