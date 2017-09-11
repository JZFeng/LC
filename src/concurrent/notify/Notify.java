package concurrent.notify;

/**
 *
 * Copyright 2010 TeleNav, Inc. All rights reserved.
 * Notify.java
 *
 */

/**
 *@author zhdong@telenav.cn
 *@date 2010-3-15
 */
public class Notify
{
    static Object lock = new Object();

    public static void main(String[] args)
    {
        new SampleThread("thread_1").start();
        new SampleThread("thread_2").start();
        new SampleThread("thread_3").start();
        new SampleThread("thread_4").start();
        new SampleThread("thread_5").start();
        new SampleThread("thread_6").start();
        new SampleThread("thread_7").start();
        new SampleThread("thread_8").start();

        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        synchronized (lock)
        {
            System.out.println("invoke lock.notify() the 1st time");
            lock.notify();
        }

        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        synchronized (lock)
        {
            System.out.println("invoke lock.notify() the 2nd time");
            lock.notify();
        }

        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        synchronized (lock)
        {
            System.out.println("invoke notifyAll() finally");
            lock.notifyAll();
        }

        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    static class SampleThread extends Thread
    {
        public SampleThread(String name)
        {
            super(name);
        }

        public void run()
        {
            synchronized (lock)
            {
                System.out.println("wait for notify in thread=" + Thread.currentThread());
                try
                {
                    lock.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("get notified in thread=" + Thread.currentThread());
            }
        }
    }

}
