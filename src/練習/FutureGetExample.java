package 練習;

import java.util.concurrent.*;

public class FutureGetExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 任務 1：需要 3 秒完成
        Future<String> task1 = executor.submit(() -> {
            Thread.sleep(3000);
            return "Task 1 completed";
        });

        // 任務 2：需要 1 秒完成
        Future<String> task2 = executor.submit(() -> {
            Thread.sleep(1000);
            System.out.println("Task 2 executed");
            return "Task 2 completed";
        });

        // 任務 3：需要 2 秒完成
        executor.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Task 3 executed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 主線程會在這裡等待 Task 1 完成
        System.out.println(task1.get()); // 阻塞主線程，等待 Task 1 完成

        // 獲取 Task 2 的結果（已經完成，不會阻塞）
        System.out.println(task2.get());

        executor.shutdown();
    }
}
