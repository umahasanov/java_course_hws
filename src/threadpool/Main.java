package threadpool;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();

        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            Runnable runnable = () -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.format("%d %d\n", Thread.currentThread().getId(), finalI);
            };
            threadPool.execute(runnable);

        }

        threadPool.start(4);

    }
}
