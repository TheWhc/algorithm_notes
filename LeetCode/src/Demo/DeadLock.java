package Demo;

/**
 * @ClassName: Demo.DeadLock
 * @Author: whc
 * @Date: 2021/03/29/15:47
 */
public class DeadLock {
	static Object o1 = new Object();
	static Object o2 = new Object();

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o1) {
					System.out.println("线程1锁01");
					try {
						Thread.sleep(1000); // 让当前线程休眠,保证另一个线程能够得到o2
						synchronized (o2) {
							System.out.println("线程1锁o2");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o2) {
					System.out.println("线程2锁o2");
					synchronized (o1) {
						System.out.println("线程2锁o1");
					}
				}
			}
		}).start();
	}
}
