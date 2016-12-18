package threadpool;

import java.util.ArrayList;
import java.util.List;


public class ThreadPool {
    private final List<Runnable> runnables = new ArrayList<>();
    private List<Thread> threads = new ArrayList<>();

    public void start(int count) {
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(new RunnableWrapper(runnables));
            threads.add(thread);
            thread.start();
        }
    }

    public void execute(Runnable runnable) {
        synchronized (runnables) {
            runnables.add(runnable);
            runnables.notify();
        }
    }




}
