package NowCoder;

import java.util.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NowCoder {
    public static void main(String[] args) throws ScriptException {
        long startTime = System.nanoTime();
        // ================================================================
        // ListNode.ListNodeTest();
        // new Solution().StringToOperation();
        Solution.Recursion.Febonacci();
        // ================================================================
        long TotalTime = System.nanoTime() - startTime;
        // print total time
        System.out.println("Total Time: " + TotalTime / 1000000 + "ms | " + TotalTime + " nanos");
    }
}

class Solution {
    /**
     * https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=117&&tqId=37756&&companyId=239&rp=1&ru=/company/home/code/239&qru=/ta/job-code-high/question-ranking
     */
    public void twoSum() {
        System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));// [2,3]
        System.out.println(Arrays.toString(twoSum(new int[] { 20, 70, 110, 150 }, 90)));// [1,2]
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
        System.out.println(FindGreatestSumOfSubArray(new int[] { 6, -3, -2, 7, -15, 1, 2, 2 }));// 8
        System.out.println(FindGreatestSumOfSubArray(new int[] { 1, -2, 3, 10, -4, 7, 2, -5 }));// 18
        System.out.println(FindGreatestSumOfSubArray(new int[] { -10 }));// -10
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
        System.out.println(SimplePassword("YUANzhi1987"));// zvbo9441987
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
            // System.out.println(temp);
            result += temp;
        }
        return result;
    }

    /**
     * https://www.nowcoder.com/practice/fe298c55694f4ed39e256170ff2c205f?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
     */
    public void BottleChange() {
        System.out.println(BottleChange(10));// 5
        System.out.println(BottleChange(81));// 40
        System.out.println(BottleChange(100));// 50
    }

    private int BottleChange(int startBottle) {
        int totalDrink = 0;
        // System.out.println("input: " + start);
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
            // System.out.println("totalDrink: " + totalDrink + ", left: " + emptyLeft);
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
        System.out.println(SpecialStringSort("A Famous Saying: Much Ado About Nothing (2012/8)."));// A aaAAbc dFgghh:
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
        // System.out.println(str.matches(pattern));
        System.out.println(Regrex("te?t*.*", "text12.xls"));// true
        // System.out.println(Regrex("te?t*.*", "text.xls"));// true
        // System.out.println(Regrex("te?t*.*", "txt12.xls"));// false
    }

    private boolean Regrex(String target, String input) {
        target = target.toLowerCase();// 忽略大小写
        input = input.toLowerCase();// 忽略大小写
        String regex = target.replaceAll("\\*{2,}", "\\*");// 将连续的*替换为一个*
        // System.out.println(regex);
        regex = regex.replaceAll("\\?", "[0-9a-z]{1}");// replace ? with [0-9a-z]{1}, [0-9a-z]{1} means only match one
                                                       // char
        // System.out.println(regex);
        regex = regex.replaceAll("\\*", "[0-9a-z]{0,}");// replace * with [0-9a-z]{0,}, [0-9a-z]{0,} means match 0 or
                                                        // more char
        // System.out.println(regex);
        return input.matches(regex);// match the whole string
    }

    public void StringToOperation() throws ScriptException {
        System.out.println(HardCodeStringToOperation("1+4"));// 15

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

    private int StringToOperation(String input) throws ScriptException {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
        return (int) scriptEngine.eval(input);
    }

    public static class Recursion {
        public static void Febonacci() {
            System.out.println(Febonacci(10));// 55
        }

        private static int Febonacci(int i) {
            if (i == 1 || i == 2) {
                return 1;
            }
            return Febonacci(i - 1) + Febonacci(i - 2);
        }

        /**
         * @see https://www.nowcoder.com/practice/bfd8234bb5e84be0b493656e390bdebf?tpId=37&tqId=21284&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%25E8%258B%25B9%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=%E8%8B%B9
         */
        public void Putapple() {
            System.out.println(Putapple(7, 3));// 8
        }

        /**
         * 
         * @param m 苹果数
         * @param n 盘子数
         * @return 不同方法总数
         *         递归的核心是递进和回归，递进就是要逐渐减小问题规模，回归要保证有出口（或称base
         *         case）。如何减小问题规模呢？m个苹果放进n个盘子，求不同放法的种数，可以分为两类情况：
         *         1.让每个盘子都有苹果放着。
         *         2.至少有一个盘子空着。有且仅有这两种情况，两种情况没有交集。7个苹果放进3个盘子，共有8种不同放法，可以用此实例加深以上理解。
         *         现在，用f(m,n)表示将m个苹果放进n个盘子不同放法的种：
         *         第一种情况相当于给每个盘子先发1个苹果，再将m-n个苹果放进n个盘子里，不同放法种数为f(m-n,n)。
         *         第二种情况相当于摒弃掉空着的那个盘子，将m个苹果放进n-1个盘子里，不同放法种数为f(m,n-1)。
         *         因此，f(m,n) = f(m-n,n)+f(m,n-1)。至此，问题规模已经减小了，再结合递归出口：
         *         当此事件分到苹果数为0或苹果数为1或盘子数为1的时候返回1，当苹果数小于0或盘子数小于等于0返回0，就可以完成求解了。
         */

        private int Putapple(int m, int n) {
            if (m < 0 || n <= 0)
                return 0;
            if (m == 1 || m == 0 || n == 1) {
                return 1;
            }
            return Putapple(m - n, n) + Putapple(m, n - 1);
        }

        /**
         * @see https://www.nowcoder.com/practice/1221ec77125d4370833fd3ad5ba72395?tpId=37&tqId=21260&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FjudgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%25E5%2585%2594%25E5%25AD%2590%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=3&tags=&title=%E5%85%94%E5%AD%90
         */
        public void RabbitCount() {
            System.out.println(RabbitCount(3));// 2
        }

        /**
         * 
         * @param i 第i个月
         * @return 第i个月的兔子总数
         * 
         *         3月的兔子数为2月的兔子数加上1月的兔子数, 所以问题拆解为RabbitCount(i-1)+RabbitCount(i-2)
         */
        private int RabbitCount(int month) {
            if (month <= 2) {// 1月和2月的兔子数都为1
                return 1;
            }
            // RabbitCount(month - 1) 表示为上个月的兔子数，
            // RabbitCount(month - 2)表示为上上个月的兔子数，两者相加即为本月的兔子数，
            return RabbitCount(month - 1) + RabbitCount(month - 2);
        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public static void ListNodeTest() {
        ListNode list = new ListNode(0);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);

        list.printAll();
        list = ListNode.anotherReverseList(list);
        list.printAll();
    }

    public void printAll() {
        ListNode p = this;
        while (p != null) {
            System.out.print(p.val + ", ");
            p = p.next;
        }
        System.out.println();
    }

    // https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=295&tqId=23286&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode temp = null;
        while (head != null) {
            // 1. a temp node to store the next node and it's linked ListNodes, prepare to
            // instead the previous node(remove the head's Head node):
            temp = head.next;
            // 2. link the newHead after the head's Head node:
            head.next = newHead;
            // 3. move the newHead to the head's Head node:
            newHead = head;
            // 4. remove the head's Head node, which means move the head to the next node
            head = temp;
        }
        return newHead;
    }

    public static ListNode anotherReverseList(ListNode head) {

        ListNode result = null;
        ArrayList<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        System.out.println(nums.toString());

        for (int i = 0; i < nums.size(); i++) {
            if (result == null) {
                result = new ListNode(nums.get(i));
            } else {
                ListNode temp = new ListNode(nums.get(i));
                temp.next = result;
                result = temp;
            }
        }
        return result;
    }
}
