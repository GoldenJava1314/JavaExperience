package 練習;

public class MainThreadExample {
    public static void main(String[] args) {
        System.out.println("這是主執行緒開始執行的部分");

        // 創建一個新的執行緒
        Thread workerThread = new Thread(() -> {
            System.out.println("這是工作執行緒運行的部分");
        });

        // 啟動工作執行緒
        workerThread.start();

        System.out.println("主執行緒繼續執行其他邏輯");
    }
}
