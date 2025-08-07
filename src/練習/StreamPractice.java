package 練習;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        // 建立一個原始的清單
        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");

//        // 使用 Stream 過濾包含字母 'e' 的字串並收集結果
//        List<String> filteredWords = words.parallelStream()
//                .filter(word -> word.contains("e")) // 過濾包含 'e' 的字串
//                .collect(Collectors.toList());    // 收集結果到新清單
//
//        // 印出結果
//        System.out.println("包含字母 'e' 的字串: " + filteredWords);
        
//        List<String> unsafeList = new ArrayList<>();
//        words.parallelStream()
//                .filter(word -> word.contains("e"))
//                .forEach(word -> unsafeList.add(word)); // 非線程安全操作
//        System.out.println("非線程安全的集合: " + unsafeList);
        
        List<String> safeList = new ArrayList<>();
        List<String> synchronizedList = java.util.Collections.synchronizedList(safeList);

        words.parallelStream()
                .filter(word -> word.contains("e"))
                .forEach(word -> synchronizedList.add(word));

        System.out.println("線程安全的集合: " + synchronizedList);
        
    }
}