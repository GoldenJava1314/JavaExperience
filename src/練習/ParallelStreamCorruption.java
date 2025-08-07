package 練習;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreamCorruption {
    public static void main(String[] args) {
        // 建立原始資料
        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");

        // 非線程安全的清單
        List<String> shortList = new ArrayList<>();

        // 並行處理過濾條件並嘗試直接加入 shortList
        words.parallelStream()
             .filter(word -> word.contains("e")) // 篩選包含 'e' 的字串
             .forEach(word -> shortList.add(word)); // 非線程安全操作

        // 印出結果
        System.out.println("篩選結果（可能損壞的資料）： " + shortList);
    }
}
