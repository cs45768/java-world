package cn.zch.innerclasses;

/**
* 匿名类
* 
* 另一种常见用法是创建过程对象，比如Runnable、Thread实例等。
* @author zch
*/
public class AnonymousClassTest2 {
	static class Anonymous implements Runnable{
		@Override 
		public void run(){
			System.out.println("do something only once");
		}
	}
	public static void main(String[] args) { 
		//常规方式（定义一个静态成员类，也可以单独定义）
		new Thread(new Anonymous()).start(); 
		
		//实现接口的匿名类
		new Thread(new Runnable(){
			@Override 
			public void run(){
				System.out.println("do something only once");
			}
		}).start(); 
		//继承基类的匿名类
		new Thread(){
			@Override 
			public void run(){
				System.out.println("do something only once");
			}
		}.start();
	}
}
