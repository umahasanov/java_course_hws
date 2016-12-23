package jmm;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 19.12.16.
 */
public class ExecutionManagerImpl implements ExecutionManager {

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        if (tasks != null) {
            for (int i = 0; i < tasks.length; i++) {
                threadPool.execute(tasks[i]);
            }
        }

        return null;
    }
}
