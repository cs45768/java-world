package com.zch.concurrent.sychronized;

/**
* 1.是否使用synchronized关键字的不同
* 
* @author zch
*/
public class ThreadTest {

	public static void main(String[] args) {
		Example example = new Example();

        Thread t1 = new Thread1(example);
        Thread t2 = new Thread1(example);

        t1.start();
        t2.start();

	}

}

class Example
{
	/*
	 * 是否在execute()方法前加上synchronized关键字，这个例子程序的执行结果会有很大的不同。
	       如果不加synchronized关键字，则两个线程同时执行execute()方法，输出是两组并发的。
                 如果加上synchronized关键字，则会先输出一组0到9，然后再输出下一组，说明两个线程是顺次执行的。
    */
    public synchronized void execute()
    {
        for (int i = 0; i < 10; ++i)
        {
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" Hello: " + i);
        }
    }

}

class Thread1 extends Thread
{
    private Example example;

    public Thread1(Example example)
    {
        this.example = example;
    }

    @Override
    public void run()
    {
        example.execute();
    }

}