package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 18.12.16.
 */
public class ContextImpl implements Context {
    private AtomicInteger complitedTaskCount;
    private AtomicInteger failedTaskCount;
    private AtomicInteger interruptedTaskCount;

    @Override
    public int getCompletedTaskCount() {
        return 0;
    }

    @Override
    public int getFailedTaskCount() {
        return 0;
    }

    @Override
    public int getInterruptedTaskCount() {
        return 0;
    }

    @Override
    public void interrupt() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
