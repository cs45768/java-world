package com.zch.concurrent.sychronized;

/**
*4. synchronized块 
* 
* 例子程序4所达到的效果和例子程序2的效果一样，都是使得两个线程的执行顺序进行，而不是并发进行，当一个线程执行时，将object对象锁住，另一个线程就不能执行对应的块。
synchronized方法实际上等同于用一个synchronized块包住方法中的所有语句，然后在synchronized块的括号中传入this关键字。当然，如果是静态方法，需要锁定的则是class对象。
可能一个方法中只有几行代码会涉及到线程同步问题，所以synchronized块比synchronized方法更加细粒度地控制了多个线程的访问，只有synchronized块中的内容不能同时被多个线程所访问，方法中的其他语句仍然可以同时被多个线程所访问（包括synchronized块之前的和之后的）。
注意：被synchronized保护的数据应该是私有的。
* @author zch
*/
public class ThreadTest4 {

	public static void main(String[] args)
    {
        Example4 example = new Example4();

        Thread t1 = new Thread4_1(example);
        Thread t2 = new Thread4_2(example);

        t1.start();
        t2.start();
    }

}

class Example4
{
    private Object object = new Object();

    public void execute()
    {
       /* synchronized (object)*/
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

    }

    public void execute2()
    {
      /*  synchronized (object)*/
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

}

class Thread4_1 extends Thread
{
    private Example4 example;

    public Thread4_1(Example4 example)
    {
        this.example = example;
    }

    @Override
    public void run()
    {
        example.execute();
    }

}

class Thread4_2 extends Thread
{
    private Example4 example;

    public Thread4_2(Example4 example)
    {
        this.example = example;
    }

    @Override
    public void run()
    {
        example.execute2();
    }

}
