package 練習;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();

        // 提交一個任務，返回結果 "Task 1 Done"
        Future<String> future1 = executor.submit(() -> {
            Thread.sleep(1000);
            return "Task 1 Done";
        });

        // 提交另一個任務，返回結果 "Task 2 Done"
        Future<String> future2 = executor.submit(() -> {
            Thread.sleep(2000);
            return "Task 2 Done";
        });

        // 檢查任務完成狀態
        while (!future1.isDone() || !future2.isDone()) {
            System.out.println("Waiting for tasks to complete...");
            Thread.sleep(500);
        }

        // 獲取結果
        System.out.println(future1.get());
//        System.out.println(future2.get());

        executor.shutdown();
    }
}
