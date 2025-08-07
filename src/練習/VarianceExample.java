package 練習;

import java.util.*;

public class VarianceExample {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Number> numList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        // ❌ 不變（Invariant） - 無法轉換
        // List<Number> nums = intList; // 編譯錯誤！

        // ✅ 協變（Covariant） - ? extends Number
        List<? extends Number> covariantList = intList;
        Number n = covariantList.get(0); // ✅ 可以讀
//         covariantList.add(100); // ❌ 無法寫入，因為型別不明確

        // ✅ 逆變（Contravariant） - ? super Integer
        List<? super Integer> contravariantList = numList;
        contravariantList.add(10); // ✅ 可以寫入 Integer
        contravariantList.add(99); // ✅ 也可以寫入其他 Integer
        // Integer i = contravariantList.get(0); // ❌ 無法保證取出是 Integer，只能當 Object

        // 🔁 確認 contravariantList 寫入後內容
        for (Object obj : contravariantList) {
            System.out.println("contravariantList item: " + obj);
        }
       System.out.println("==================================");
        String s1 = new String("ORACLE");
        String s2 = "ORACLE";
        String s3 = s1.intern();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println((s1==s2) + " ");
        System.out.println((s2==s3) + " ");
        System.out.println((s1==s3) + " ");
    }
}
