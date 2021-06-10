package Demo;

/**
 * @ClassName: Demo.SingletonTest
 * @Author: whc
 * @Date: 2021/04/02/22:25
 */
public class SingletonTest {

	private static SingletonTest singletonTest = null;

	// 限制产生多个对象
	private SingletonTest() {}

	// 通过该方法获取实例对象
	public static SingletonTest getSingleton() {
		if(singletonTest == null) {
			singletonTest = new SingletonTest();
		}

		return singletonTest;
	}

}
