/**
 *
 * Copyright 2010 TeleNav, Inc. All rights reserved.
 * AbstractModel.java
 *
 */
package concurrent.deadLock;

/**
 * 
 * This is a bad example of my own.
 * 
 * @author zhdong@telenav.cn
 *@date 2010-3-15
 */
public abstract class DeadLockAbstractModel
{

    /**
     * Business action according to action id.
     * 
     * @param actionId
     */
    protected abstract void doAction(int actionId);
}
