package 并发.生产者和消费者问题.wait和notify;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: Main
 * @Author: whc
 * @Date: 2021/10/01/15:44
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		// 1. 构建内存缓冲区
		Vector shareQueue = new Vector();
		int size = 4;

		// 2. 建立线程池和线程
		ExecutorService service = Executors.newCachedThreadPool();
		Producer prodThread1 = new Producer(shareQueue, size);
		Producer prodThread2 = new Producer(shareQueue, size);
		Producer prodThread3 = new Producer(shareQueue, size);
		Consumer consumer1 = new Consumer(shareQueue, size);
		Consumer consumer2 = new Consumer(shareQueue, size);
		Consumer consumer3 = new Consumer(shareQueue, size);

		service.execute(prodThread1);
		service.execute(prodThread2);
		service.execute(prodThread3);
		service.execute(consumer1);
		service.execute(consumer2);
		service.execute(consumer3);

		// 3. 休眠然后尝试停止生产者
		Thread.sleep(10 * 1000);
		prodThread1.stop();
		prodThread2.stop();
		prodThread3.stop();

		// 4. 再睡一会儿关闭线程池
		Thread.sleep(3000);
		service.shutdown();
	}
}
