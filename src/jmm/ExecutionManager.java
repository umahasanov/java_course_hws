package jmm;

/**
 * Created by Administrator on 18.12.16.
 */
public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
