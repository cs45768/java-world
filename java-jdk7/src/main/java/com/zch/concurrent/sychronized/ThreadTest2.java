package com.zch.concurrent.sychronized;

/**
* 2.多个方法的多线程情况
* 
* 
* 如果一个对象有多个synchronized方法，某一时刻某个线程已经进入到了某个synchronized方法，
* 那么在该方法没有执行完毕前，其他线程是无法访问该对象的任何synchronized方法的。
结论：
当synchronized关键字修饰一个方法的时候，该方法叫做同步方法。
* @author zch
*/
public class ThreadTest2 {

	public static void main(String[] args)
    {
        Example2 example = new Example2();

        Thread t1 = new Thread2_1(example);
        Thread t2 = new Thread2_2(example);

        t1.start();
        t2.start();
    }

}

class Example2
{
    /**
    * <p>Title: execute<／p>
    * <p>Description: <／p>
    */
    public /*synchronized*/ void execute()
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

    public /*synchronized*/ void execute2()
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

class Thread2_1 extends Thread
{
    private Example2 example;

    public Thread2_1(Example2 example)
    {
        this.example = example;
    }

    @Override
    public void run()
    {
        example.execute();
    }

}

class Thread2_2 extends Thread
{
    private Example2 example;

    public Thread2_2(Example2 example)
    {
        this.example = example;
    }

    @Override
    public void run()
    {
        example.execute2();
    }

}
