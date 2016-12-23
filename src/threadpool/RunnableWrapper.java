package threadpool;

import java.util.List;

public class RunnableWrapper implements Runnable {
    private final List<Runnable> runnables;

    public RunnableWrapper(List<Runnable> runnables) {
        this.runnables = runnables;
    }

    @Override
    public void run() {

        while (true) {

            Runnable runnable;
            synchronized (runnables) {
                while (runnables.isEmpty()) {
                    try {
                        runnables.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                runnable = runnables.get(0);
                runnables.remove(0);
            }

            try {
                runnable.run();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }




}
