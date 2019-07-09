package com.zch.concurrent.lock;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁与非公平锁
 */
public class FairAndUnfairTest {

    private static Lock fairLock = new ReentrantLock2(true);

    private static Lock unfairLock = new ReentrantLock2(false);



    private void testLock(Lock lock){
        Job job1 = new Job(lock);
        Job job2 = new Job(lock);
        Job job3 = new Job(lock);
        Job job4 = new Job(lock);
        Job job5 = new Job(lock);
        job1.start();
        job2.start();
        job3.start();
        job4.start();
        job5.start();
    }

    private static class Job extends Thread{
        private Lock lock;
        public Job(Lock lock){
            this.lock = lock;
        }
        public void run(){
            System.out.println(">--"+Thread.currentThread().getName()+Thread.currentThread().toString());
            System.out.println(lock.newCondition().toString());
        }
    }

    private static class ReentrantLock2 extends ReentrantLock{

        public ReentrantLock2(boolean fair){
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads(){
            List<Thread> arrayList = new ArrayList<Thread>(super.
                    getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }

    }


    public static void main(String[] args) {
        FairAndUnfairTest test = new FairAndUnfairTest();
        test.testLock(fairLock);
    }
}
