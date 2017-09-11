/**
 *
 * Copyright 2010 TeleNav, Inc. All rights reserved.
 * AbstractController.java
 *
 */
package concurrent.deadLock;

/**
 * 
 * This is a bad example of my own.
 * 
 *@author zhdong@telenav.cn
 *@date 2010-3-15
 */
public class DeadLockAbstractController
{
    static Object eventLock = new Object();

    private DeadLockAbstractModel model;

    public final boolean handleModelEvent(int eventID)
    {
        synchronized (eventLock)
        {
            // ......
            return handleTrigger(eventID);
        }
    }

    private final boolean handleTrigger(int trigger)
    {
        // ......
        int actionId = getActionFromStateMachine(trigger);
        model.doAction(actionId);
        // ......
        return true;
    }

    private int getActionFromStateMachine(int trigger)
    {
        return trigger;
    }
}
