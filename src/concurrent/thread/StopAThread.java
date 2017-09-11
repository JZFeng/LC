/**
 *
 * Copyright 2010 TeleNav, Inc. All rights reserved.
 * StopAThread.java
 *
 */
package concurrent.thread;

/**
 * 
 * This is a demo which shows how to stop a thread.
 * 
 * NOTE: Never use Thread.stop() to stop a Thread!
 * 
 * @author zhdong@telenav.cn
 *@date 2010-3-15
 */
public class StopAThread
{
    public static void main(String[] args)
    {
        DemoTask task = new DemoTask();
        task.start();

        try
        {
            Thread.sleep(15000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        task.cancel();

        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    static class DemoTask extends Thread
    {
        boolean isCancelled = false;

        public void run()
        {
            while (!isCancelled)
            {
                System.out.println("I am working ...");

                synchronized (this)
                {
                    try
                    {
                        this.wait(4000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("Go home! Go Go Go ...");

        }

        public void cancel()
        {
            System.out.println("It is time to go home.");
            isCancelled = true;
            synchronized (this)
            {
                this.notify();
            }
        }
    }

}
