package stampede;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Elephant {
	public static void main(String[] args) {
		List<String> fruits = List.of("apple", "banana", "kiwi", "orange");

        // 串流管線：
        // 1. 篩選出長度大於 4 的水果
        // 2. 偷看每個經過的元素，並將其印出
        // 3. 將所有元素轉換為大寫
        // 4. 終端操作：收集成一個新的 List
        List<String> result = fruits.stream()
                .filter(fruit -> fruit.length() > 4)
                .peek(fruit -> System.out.println("經過 filter 後的元素: " + fruit))
                .map(String::toUpperCase)
                .peek(fruit -> System.out.println("經過 map 後的元素: " + fruit))
                .collect(Collectors.toList());

        System.out.println("---");
        System.out.println("最終結果: " + result);
	}
	
    }
