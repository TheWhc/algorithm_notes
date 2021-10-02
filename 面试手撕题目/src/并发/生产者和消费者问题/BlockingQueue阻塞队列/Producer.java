package 并发.生产者和消费者问题.BlockingQueue阻塞队列;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: Producer
 * @Author: whc
 * @Date: 2021/10/01/15:50
 *
 * BlockingQueue阻塞队列实现
 *
 * 不需要手动的去通知其它线程,生产者直接往队列中放数据直到队列满,消费者直接从队列中获取数据直到队列为空,
 * BlockingQueue会自动帮我们完成阻塞这个动作
 */
public class Producer implements Runnable {

	private volatile boolean isRunning = true;
	private BlockingQueue<Integer> queue;
	private static AtomicInteger count = new AtomicInteger();
	private static final int SLEEPTIME = 1000;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
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

				// 往阻塞队列中添加数据
				data = count.incrementAndGet();
				System.out.println("producer" + Thread.currentThread().getId() + "create data:" + data + ",size:" + queue.size());
				// 注意: 对阻塞队列添加失败的错误处理
				if(!queue.offer(data, 2, TimeUnit.SECONDS)) {
					System.err.println("failed to put data:" + data);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupted();
		}
	}

	public void stop() {
		isRunning = false;
	}
}
