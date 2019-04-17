package com.zch.concurrent.sychronized;

/**
* 3.考虑静态的同步方法
* 
* 如果某个synchronized方法是static的，那么当线程访问该方法时，
* 它锁的并不是synchronized方法所在的对象，而是synchronized方法所在的类所对应的Class对象。
* Java中，无论一个类有多少个对象，这些对象会对应唯一一个Class对象，
* 因此当线程分别访问同一个类的两个对象的两个static，synchronized方法时，它们的执行顺序也是顺序的，
* 也就是说一个线程先去执行方法，执行完毕后另一个线程才开始。
* 
* @author zch
*/
public class ThreadTest3 {
	public static void main(String[] args)
    {
        Example3 example = new Example3();

        Thread t1 = new Thread3_1(example);

        // 此处即便传入不同的对象，静态方法同步仍然不允许多个线程同时执行
        example = new Example3();

        Thread t2 = new Thread3_2(example);

        t1.start();
        t2.start();
    }

}

class Example3
{
    public /*synchronized*/ static void execute()
    {
        for (int i = 0; i < 20; ++i)
        {
            try
            {
                Thread.sleep((long) Math.random() * 1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" Hello: " + i);
        }
    }

    public /*synchronized*/ static void execute2()
    {
        for (int i = 0; i < 20; ++i)
        {
            try
            {
                Thread.sleep((long) Math.random() * 1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" World: " + i);
        }
    }

}

class Thread3_1 extends Thread
{
    private Example3 example;

    public Thread3_1(Example3 example)

    {
        this.example = example;
    }

    @Override
    public void run()
    {
    	example.execute();
    }

}

class Thread3_2 extends Thread
{
    private Example3 example;

    public Thread3_2(Example3 example)
    {
        this.example = example;
    }

    @Override
    public void run()
    {
    	example.execute2();
    }

}
