package 練習;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.ArrayDeque; // ArrayDeque 可以當作 Stack 用，且效率通常比 Stack 更好
import java.util.Deque;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set; // 推薦使用 Set 介面來宣告，HashSet 是其實現類
import java.util.Scanner;
public class ChatGPT {

private static int[][] maze;
private static int R, C;
// 使用 Map 儲存記憶化的結果：鍵為 (row * C + col) 的唯一識別碼，值為路徑數
private static Map<Integer, Integer> memo;

public static void main(String[] args) {
 

	 Scanner scanner = new Scanner(System.in);

     System.out.print("請輸入排序好的整數陣列 (用逗號分隔，例如: 1,3,5,6): ");
     String numsStr = scanner.nextLine();
     String[] numStrs = numsStr.split(",");
     int[] nums = new int[numStrs.length];
     for (int i = 0; i < numStrs.length; i++) {
         nums[i] = Integer.parseInt(numStrs[i].trim());
     }

     System.out.print("請輸入目標值 target: ");
     int target = scanner.nextInt();

     int index = searchInsert(nums, target);
     System.out.println("目標值 " + target + " 的插入位置或索引是: " + index);

     scanner.close();
 }

 /**
  * 在排序好的陣列中搜尋目標值，如果存在則返回索引，否則返回插入位置。
  *
  * @param nums 排序好的整數陣列
  * @param target 目標值
  * @return 目標值的索引或插入位置
  */
 public static int searchInsert(int[] nums, int target) {
     // 初始化左右指針
     int left = 0;
     int right = nums.length - 1;

     // 當 left <= right 時，搜尋範圍仍然有效
     while (left <= right) {
         // 計算中間元素的索引
         // 避免 left + right 溢出的更安全寫法：left + (right - left) / 2
         int mid = left + (right - left) / 2;

         // 比較中間元素與目標值
         if (nums[mid] == target) {
             // 如果找到目標值，直接返回其索引
             return mid;
         } else if (nums[mid] < target) {
             // 如果中間元素小於目標值，說明目標值在右半部分
             // 將 left 指針移動到 mid + 1
             left = mid + 1;
         } else { // nums[mid] > target
             // 如果中間元素大於目標值，說明目標值在左半部分 (或就是 mid 這個位置，如果它不存在)
             // 將 right 指針移動到 mid - 1
             right = mid - 1;
         }
     }

     // 迴圈結束時，left 指針指向的是 target 應該被插入的位置
     // 此時，left 會是第一個大於或等於 target 的元素的索引
     // 如果 target 比所有元素都大，left 會指向 nums.length
     return left;
 }
}