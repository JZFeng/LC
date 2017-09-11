/**
 *
 * Copyright 2010 TeleNav, Inc. All rights reserved.
 * Sync.java
 *
 */
package concurrent.sync;

/**
 *@author zhdong@telenav.cn
 *@date 2010-3-15
 */
public class Sync
{
    Object lock = new Object();

    static Object staticLock = new Object();

    // What is the lock for the following functions?

    public synchronized void function()
    {
        // part 1 ...
        System.out.println("part 1 is done.");
        
        // part 2 ...
        System.out.println("part 2 is done.");
        
        // part 3 ...
        System.out.println("part 3 is done.");
    }

    public static synchronized void staticFunction()
    {
        // static part 1 ...
        System.out.println("static part 1 is done.");
        
        // static part 2 ...
        System.out.println("static part 2 is done.");
        
        // static part 3 ...
        System.out.println("static part 3 is done.");
    }
    
    //Question 1: if we only want part 2 to be locked, how to modify the codes?

}
