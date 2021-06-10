package Demo;

/**
 * @ClassName: Demo.Singleton
 * @Author: whc
 * @Date: 2021/03/10/20:27
 */
public class Singleton {
	private volatile static Singleton singleton;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				// 在判断一次的原因: 可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例了。
				if (singleton == null) {
					// 对象创建过程: 1. 分配对象内存空间 2. 初始化对象 3. 设置instance指向分配的内存空间
					// 2和3可能会发生指令重排,如果发生指令重排的话,此时线程2执行getInstance方法,那么就会得到instance不为空,
					// 就会拿到半初始化的instance,如果加了volatile关键字就会避免指令重排问题
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
