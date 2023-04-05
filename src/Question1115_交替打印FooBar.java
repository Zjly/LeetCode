/**
 * 1115. 交替打印 FooBar
 * 给你一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 * for (int i = 0; i < n; i++) {
 * print("foo");
 * }
 * }
 * <p>
 * public void bar() {
 * for (int i = 0; i < n; i++) {
 * print("bar");
 * }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例：
 * <p>
 * 线程 A 将会调用 foo() 方法，而
 * 线程 B 将会调用 bar() 方法
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出："foobar"
 * 解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出："foobarfoobar"
 * 解释："foobar" 将被输出两次。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */

public class Question1115_交替打印FooBar {
	public static void main(String[] args) {

	}
}

class FooBar {
	private volatile int n;
	private Object lock = new Object();
	boolean first = true;

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {
		for(int i = 0; i < n; i++) {
			synchronized(lock) {
				while(!first) {
					lock.wait();
				}
				printFoo.run();
				first = false;
				lock.notifyAll();
			}
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for(int i = 0; i < n; i++) {
			synchronized(lock) {
				while(first) {
					lock.wait();
				}
				printBar.run();
				first = true;
				lock.notifyAll();
			}
		}
	}
}
