/**
 *
 * Copyright 2010 TeleNav, Inc. All rights reserved.
 * Wait.java
 *
 */
package concurrent.wait;

/**
 * This is a bad example from CN map project.
 * 
 *@author zhdong@telenav.cn
 *@date 2010-3-15
 */
public class Wait extends Thread
{
    private volatile boolean pause = true;

    private void repaint()
    {
        System.out.println("repaint");
    }

    public void run()
    {
        while (true)
        {
            while (pause)
            {
                try
                {
                    this.wait(1000);
                }
                catch (Exception e)
                {
                }
            }

            try
            {
                Thread.sleep(500);
            }
            catch (Exception e)
            {
            }

            synchronized (this)
            {
                if (pause)
                    continue;

                repaint();
            }
        }
    }

}
