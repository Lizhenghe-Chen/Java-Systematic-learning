package NowCoder;

import java.util.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import MyTools.*;

public class NowCoder {
    public static void main(String[] args) throws ScriptException {
        long startTime = System.nanoTime();
        // ================================================================
        // ListNode.ListNodeTest();
        new Solution().Dichotomy(
                new int[] { 2, 3, 0, 1, 5, 15, 25, 33, 22, 8, 9, 10, 66, 4, 6, 7, 8, 0 },
                22, true);
        // Recursion.Febonacci();
        // ================================================================
        long TotalTime = System.nanoTime() - startTime;
        // print total time
        Tools.println("Total Time: " + TotalTime / 1000000 + "ms | " + TotalTime + " nanos");
    }
}

class Solution {
    /**
     * https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=117&&tqId=37756&&companyId=239&rp=1&ru=/company/home/code/239&qru=/ta/job-code-high/question-ranking
     */
    public void twoSum() {
        Tools.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));// [2,3]
        Tools.println(Arrays.toString(twoSum(new int[] { 20, 70, 110, 150 }, 90)));// [1,2]
    }

    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    private int[] twoSum(int[] numbers, int target) {
        // write code here
        // Better Solution:
        /*
         * Map<Integer, Integer> m = new HashMap<>();
         * for (int i = 0; i < nums.length; i++) {
         * if (m.get(target - nums[i]) != null) {
         * return new int[] { m.get(target - nums[i]) + 1, i + 1 };
         * }
         * m.put(nums[i], i);//如果没有找到，就把当前的值和下标存入map中
         * }
         * return new int[] { 0, 0 };
         */

        int tempTarget = 0;
        int result[] = new int[] {};
        loop1: for (int i = 0; i < numbers.length; i++) {
            tempTarget = target - numbers[i];
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] == tempTarget && j != i) {
                    if (i < j) {
                        result = new int[] { i + 1, j + 1 };
                    } else {
                        result = new int[] { j + 1, i + 1 };
                    }
                    break loop1;
                }
            }

        }
        return result;
    }

    /**
     * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=117&companyId=239&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F239&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&difficulty=&judgeStatus=&tags=&title=&sourceUrl=&gioEnter=menu
     */
    public void FindGreatestSumOfSubArray() {
        Tools.println(FindGreatestSumOfSubArray(new int[] { 6, -3, -2, 7, -15, 1, 2, 2 }));// 8
        Tools.println(FindGreatestSumOfSubArray(new int[] { 1, -2, 3, 10, -4, 7, 2, -5 }));// 18
        Tools.println(FindGreatestSumOfSubArray(new int[] { -10 }));// -10
    }

    private int FindGreatestSumOfSubArray(int[] array) {
        int maxResult = array[0];
        int tempCal = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                tempCal += array[j];
                maxResult = Math.max(maxResult, tempCal);
            }
            tempCal = 0;
        }
        return maxResult;
        // Better Solution:
        /*
         * int sum = 0;
         * int max = array[0];
         * for(int i=0;i<array.length;i++){
         * // 优化动态规划，确定sum的最大值
         * sum = Math.max(sum + array[i], array[i]);
         * // 每次比较，保存出现的最大值
         * max = Math.max(max,sum);
         * }
         * return max;
         */

    }

    /**
     * https://www.nowcoder.com/practice/7960b5038a2142a18e27e4c733855dac?tpId=37&tqId=21244&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public void SimplePassword() {
        Tools.println(SimplePassword("YUANzhi1987"));// zvbo9441987
    }

    private String SimplePassword(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            // int temp = (int) temp;
            // A~Z:
            if (temp >= 'A' && temp <= 'Z') {
                temp += 32 + 1; // to lower case then move next
                if (temp > 'z') {
                    temp = 'a';
                }

            } // 0~9
            else if (temp >= '0' && temp <= '9') { // do nothing
            }

            // a~z
            else if (temp >= 'a' && temp <= 'z') {
                // abc
                if (temp >= 'a' && temp <= 'c') {
                    temp = '2';
                }
                // def
                else if (temp >= 'd' && temp <= 'f') {
                    temp = '3';
                }
                // ghi
                else if (temp >= 'g' && temp <= 'i') {
                    temp = '4';
                }
                // jkl
                else if (temp >= 'j' && temp <= 'l') {
                    temp = '5';
                }
                // mno
                else if (temp >= 'm' && temp <= 'o') {
                    temp = '6';
                }
                // pqrs
                else if (temp >= 'p' && temp <= 's') {
                    temp = '7';
                }
                // tuv
                else if (temp >= 't' && temp <= 'v') {
                    temp = '8';
                }
                // wxyz
                else if (temp >= 'w' && temp <= 'z') {
                    temp = '9';
                }
            }
            // Tools.println(temp);
            result += temp;
        }
        return result;
    }

    /**
     * https://www.nowcoder.com/practice/fe298c55694f4ed39e256170ff2c205f?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
     */
    public void BottleChange() {
        Tools.println(BottleChange(10));// 5
        Tools.println(BottleChange(81));// 40
        Tools.println(BottleChange(100));// 50
    }

    private int BottleChange(int startBottle) {
        int totalDrink = 0;
        // Tools.println("input: " + start);
        int emptyLeft = startBottle;
        totalDrink = 0;
        int counter = 0;

        while (emptyLeft >= 3) {
            int times = 0;
            if (counter == 0) {
                times = (int) Math.floor(startBottle / 3);// 能换几次，每次3瓶
            } else {
                times = (int) Math.floor(emptyLeft / 3);
            }
            // System.out.print("times: " + times + ", ");
            emptyLeft -= times * 3; // 换完之后剩下的
            emptyLeft += times;// 喝完换到的之后剩下的
            totalDrink += times;
            // Tools.println("totalDrink: " + totalDrink + ", left: " + emptyLeft);
            if (emptyLeft == 2) {
                emptyLeft += 1; // 向老板借一个空瓶
            }
            counter++;
        }
        return totalDrink;
        // Better Solution:
        // return startBottle / 2;

    }

    /**
     * https://www.nowcoder.com/practice/5190a1db6f4f4ddb92fd9c365c944584?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FjudgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=&judgeStatus=3&tags=&title=&gioEnter=menu
     */
    public void SpecialStringSort() {
        Tools.println(SpecialStringSort("A Famous Saying: Much Ado About Nothing (2012/8)."));// A aaAAbc dFgghh:
                                                                                              // iimM nNn oooos
                                                                                              // Sttuuuy (2012/8).
    }

    private String SpecialStringSort(String str) {
        StringBuilder result = new StringBuilder();
        ArrayList<Character> Letterlist = new ArrayList<>();
        // 将英文字母收集起来
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                Letterlist.add(ch);
            }
        }
        // 将英文字母排序，按小写比较排序，这样同一个英文字母的大小写同时存在时，按照输入顺序排列
        Letterlist.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });
        // 将排序后的英文字母插入到原字符串中，非英文字母不变
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                result.append(Letterlist.get(0));
                Letterlist.remove(0);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    /**
     * https://www.nowcoder.com/practice/43072d50a6eb44d2a6c816a283b02036?tpId=37&tqId=21294&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FjudgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=3&tags=&title=
     */
    public void Regrex() {
        // String str = "abc";
        // String pattern = "a.*";
        // Tools.println(str.matches(pattern));
        Tools.println(Regrex("te?t*.*", "text12.xls"));// true
        // Tools.println(Regrex("te?t*.*", "text.xls"));// true
        // Tools.println(Regrex("te?t*.*", "txt12.xls"));// false
    }

    private boolean Regrex(String target, String input) {
        target = target.toLowerCase();// 忽略大小写
        input = input.toLowerCase();// 忽略大小写
        String regex = target.replaceAll("\\*{2,}", "\\*");// 将连续的*替换为一个*
        // Tools.println(regex);
        regex = regex.replaceAll("\\?", "[0-9a-z]{1}");// replace ? with [0-9a-z]{1}, [0-9a-z]{1} means only match one
                                                       // char
        // Tools.println(regex);
        regex = regex.replaceAll("\\*", "[0-9a-z]{0,}");// replace * with [0-9a-z]{0,}, [0-9a-z]{0,} means match 0 or
                                                        // more char
        // Tools.println(regex);
        return input.matches(regex);// match the whole string
    }

    public void StringToOperation() throws ScriptException {
        Tools.println(HardCodeStringToOperation("1+4"));// 15

    }

    private int HardCodeStringToOperation(String input) {
        int result = 0;
        int num = 0;
        char operator = '+';
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (!Character.isDigit(ch) && ch != ' ' || i == input.length() - 1) {
                switch (operator) {
                    case '+':
                        result += num;
                        break;
                    case '-':
                        result -= num;
                        break;
                    case '*':
                        result *= num;
                        break;
                    case '/':
                        result /= num;
                        break;
                }
                operator = ch;
                num = 0;
            }
        }
        return result;
    }

    /**
     * 
     * @param input
     * @return
     * @throws ScriptException
     */
    private int StringToOperation(String input) throws ScriptException {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
        return (int) scriptEngine.eval(input);
    }

    /**
     * given a sorted list, it is more efficiency to use Dichoyomy to search an item
     */
    public void Dichotomy(int[] list, int target, Boolean useDichotomy) {

        // Tools.println("Before Sort: " + Arrays.toString(list));
        // convert int to Integer
        // Integer[] list2 = new Integer[list.length];
        // for (int i = 0; i < list.length; i++) {
        // list2[i] = list[i];
        // }
        // Arrays.sort(list2);
        // Tools.println("After Sort: " + Arrays.toString(list2));
        Arrays.sort(list);
        int[] list2 = list;
        if (useDichotomy) {
            // dichotomy:
            int left = 0, right = list2.length - 1, mid;
            while (left <= right) {// notice: <= not < because we need to check the last item
                mid = (left + right) / 2;// find the middle index
                // Tools.println("left: " + left + ", right: " + right + ", mid: " + mid +
                // ", mid value: " + list2[mid]);
                if (list2[mid] == target) {// if the middle item is the target, return
                    Tools.println("Find the target: " + target + " at index: " + mid);
                    return;
                }
                if (list2[mid] > target) {// if the middle item is bigger than target, search the left part
                    right = mid - 1;
                } else {
                    left = mid + 1;// if the middle item is smaller than target, search the right part
                }
            }
            Tools.println("Not find the target: " + target);
        } else { // traditional way:
            for (int i = 0; i < list2.length; i++) {
                if (list2[i] == target) {
                    Tools.println("Find the target: " + target + " at index: " + i);
                    return;
                }
            }
            Tools.println("Not find the target: " + target);
        }

    }

    private void SumOfCharacter(String str) {
        char[] input = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char temp : input) {
            if (map.containsKey(temp)) {
                int tempCount = map.get(temp) + 1;
                map.replace(temp, tempCount);
            } else {
                map.put(temp, 1);
            }
        }
        // convert map to a list (nested)
        ArrayList<Map.Entry<Character, Integer>> sortList = new ArrayList<>(map.entrySet());
        Collections.sort(sortList, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return (char) o1.getKey() - (char) o2.getKey();
                } else {
                    return (int) o2.getValue() - (int) o1.getValue();
                }
            }
        });
        // Tools.println(sortList.toString());
        for (Map.Entry<Character, Integer> entry : sortList) {
            System.out.print(entry.getKey());
        }
    }

    /**
     * https://www.nowcoder.com/practice/42852fd7045c442192fa89404ab42e92?tpId=137&tqId=33895&ru=/exam/oj
     * Check("helllo");
     * Check("helloo");
     * Check("yyybeettxjjjpppddsrxxxkkkyyyooowwwwwkyyxxppplllwwwiivvssnrvvvccclyydddhaaayiic");
     *      * @param str
     */
    public void CheckSpell(String str) {
        // 检查是否有三个及以上同样的字母连在一起
        if (str.matches(".*([A-Za-z])\\1{2,}.*")) {
            // 保留两个就行
            while (str.matches(".*([A-Za-z])\\1{2,}.*")) {
                str = str.replaceFirst("([A-Za-z])\\1{2,}", "$1$1");
            }
        }
        // 检查是否两对一样的字母（AABB）连在一起, \\1{1,}表示第一个括号里的内容重复一次或多次
        if (str.matches(".*([A-Za-z])\\1{1,}([A-Za-z])\\2{1,}.*")) {
            // 保留两个就行
            while (str.matches(".*([A-Za-z])\\1{1,}([A-Za-z])\\2{1,}.*")) {
                str = str.replaceFirst("([A-Za-z])\\1{1,}([A-Za-z])\\2{1,}", "$1$1$2");
            }

        }
        System.out.println(str);
    }
}
