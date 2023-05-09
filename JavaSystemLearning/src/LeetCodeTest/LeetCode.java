package LeetCodeTest;

import java.util.*;
import javax.naming.spi.DirStateFactory.Result;

//write the interface here
interface LeetCodeQuestions {
    public void ShiftofCoordinates(String inputString);

    public void Caculate(String input, int[] total);

    public void searchInsert();

    public int searchInsert(int[] nums, int target);

    public void reverseString();

    public void reverseInteger();

    public void firstUniqChar();

    public void twoSum();

    public void intToRoman();

    public void isPalindrome();

    public void isSentencePalindrome();

    public void longestPalindrome();

    public int longestPalindrome(String[] words);

    public int removeDuplicates(int[] nums);

    public List<String> cellsInRange(String s);

    public long minimalKSum(int[] nums, int k);

    public int firstMissingPositive(int[] nums);

    public boolean isAnagram(String s, String t);

    public int myAtoi(String s);

    public String longestCommonPrefix(String[] strs);

    public int maxArea(int[] height);

    public boolean checkPalindromeFormation(String a, String b);

    boolean isPalindrome(String s, int i, int j);

    public int climbStairs(int n);
}

//
class Solution implements LeetCodeQuestions {

    public void ShiftofCoordinates() {
        ShiftofCoordinates("A1;A10;");
    }

    public void ShiftofCoordinates(String inputString) {
        int[] total = { 0, 0 };

        String[] stringList = inputString.split(";");
        // System.out.println("stringList: " + Arrays.toString(stringList));
        for (String temp : stringList) {
            Caculate(temp, total);
        }
        System.out.println("total: " + Arrays.toString(total));
    }

    public void Caculate(String input, int[] total) {
        int value = 0;
        try {
            if (input.length() == 2) {
                value = Integer.valueOf(input.substring(1, 2));
            } else if (input.length() == 3) {
                value = Integer.valueOf(input.substring(1, 3));
            } else {
                return;
            }

            // System.out.println(value);
            if (input.charAt(0) == 'A') {
                total[0] -= value;
            }
            if (input.charAt(0) == 'S') {
                total[1] -= value;
            }
            if (input.charAt(0) == 'D') {
                total[0] += value;
            }
            if (input.charAt(0) == 'W') {
                total[1] += value;
            }
        } catch (Exception e) {
            return; // only intenger can be allowed
        }

    }

    public void searchInsert() {
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5));// 2
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 2));// 1
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7));// 4
        System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 0));// 0
    }

    public int searchInsert(int[] nums, int target) {
        // consider the target is at the beginning of the array or the end of the array
        // first
        if (target > nums[nums.length - 1]) {
            return nums.length;
        } else if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        } else if (target < nums[0]) {
            return 0;
        }
        // then binary search
        for (int i = 0; i < nums.length - 1; i++) {
            if (target == nums[i])
                return i;
            if (nums[i] < target && target < nums[i + 1]) {
                return i + 1;
            }

        }
        return 6666;
        // better solution
        // int left = 0;
        // int right = nums.length - 1;
        // int mid = 0;
        // while (left <= right) {
        // mid = (left + right) / 2;
        // if (nums[mid] == target) {
        // return mid;
        // } else if (nums[mid] < target) {
        // left = mid + 1;
        // } else {
        // right = mid - 1;
        // }
        // }
        // return left;
    }

    public void reverseString() {
        char myChar[] = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(myChar);
    }

    /** https://leetcode.com/problems/reverse-string */
    public void reverseString(char[] s) {

        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        System.out.println(s);
    }

    /** https://leetcode.com/problems/reverse-integer/ */
    public void reverseInteger() {
        int x = -123;// 9646324351 is out of range!!
        System.out.println(reverseInteger(x));
    }

    public int reverseInteger(int x) {

        // try {
        // if (x < 0) {
        // return -Integer.parseInt(new
        // StringBuilder(String.valueOf(-x)).reverse().toString());
        // } else {
        // return Integer.parseInt(new
        // StringBuilder(String.valueOf(x)).reverse().toString());
        // }
        // } catch (Exception e) {
        // return 0;
        // }
        // better solution:
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    /** https://leetcode.com/problems/first-unique-character-in-a-string/ */
    public void firstUniqChar() {
        String s = "loveleetcode";
        String s1 = "aabb";
        System.out.println(firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        // int counter = 0;
        // for (int i = 0; i < s.length(); i++) {
        // for (int j = 0; j < s.length(); j++) {
        // if (s.charAt(i) == s.charAt(j)) {
        // counter++;
        // if (counter > 1) {
        // counter = 0;
        // break;
        // }
        // }
        // if (j == s.length() - 1 && counter == 1) {
        // return i;
        // }
        // }
        // }
        // return -1;
        // Better solution:
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /** https://leetcode.com/problems/two-sum */
    public void twoSum() {
        int[] nums = { 2, 15, 11, 7 };
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + ", " + result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = i + 1; j < nums.length; j++) {
        // if (nums[i] + nums[j] == target) {
        // return new int[] { i, j };
        // }
        // }
        // }
        // return null;
        // Better solution:
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            } else
                map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    /** https://leetcode.com/problems/integer-to-roman/ */
    public void intToRoman() {
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(1994));
    }

    public String intToRoman(int num) {
        // a table with all the roman symbols
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
        // Better solution:
        // String[] M = { "", "M", "MM", "MMM" };
        // String[] C = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        // String[] X = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        // String[] I = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        // return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num %
        // 10];

    }

    public void isPalindrome() {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        return sb.toString().equals(sb.reverse().toString());
    }

    // https://leetcode.com/problems/valid-palindrome
    public void isSentencePalindrome() {
        System.out.println(isSentencePalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isSentencePalindrome("race a car"));
    }

    /**
     * replace a to z, A to Z, 0~9 with "", ^ meas except and then compare the
     * string with its
     * reverse
     * 
     * @param s
     * @return
     */
    public boolean isSentencePalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);
        StringBuffer sb = new StringBuffer(s);
        return new StringBuffer(s).toString().equals(sb.reverse().toString());
    }

    /**
     * https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
     */
    public void longestPalindrome() {
        System.out.println(longestPalindrome(new String[] { "lc", "cl", "gg" }));// "lcggcl", 6
        System.out.println(longestPalindrome(new String[] { "ab", "ty", "yt", "lc",
                "cl", "ab" }));// "tylcclyt", 8
        System.out.println(longestPalindrome(new String[] { "cc", "ll", "xx" }));// "cc", 2
        System.out.println(
                longestPalindrome(new String[] { "em", "pe", "mp", "ee", "pp", "me", "ep", "em", "em", "me" }));// 14
        System.out.println(longestPalindrome(
                new String[] { "dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc" }));// 22
        System.out.println(longestPalindrome(new String[] { "ll", "lb", "bb", "bx", "xx", "lx", "xx", "lx", "ll", "xb",
                "bx", "lb", "bb", "lb", "bl", "bb", "bx", "xl", "lb", "xx" }));// 26

    }

    /**
     * This solution is not optimal, it's seems just a brute force solution, when
     * words size are extremely large, it will take a lot of time to execute.
     * 
     * @param words the array of words
     * @return the length of
     */
    public int longestPalindrome(String[] words) {
        boolean hasOneDoubleString = false;
        // StringBuffer sb = new StringBuffer();
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));// a temp list
        int result = 0;

        while (wordsList.size() > 0) {
            // System.out.println(wordsList);
            String target = wordsList.get(0);
            String targetRev = target.charAt(1) + "" + target.charAt(0);
            wordsList.remove(0);
            if (wordsList.contains(targetRev)) {
                // sb.append("[" + target + ", ");
                // sb.append(targetRev + "], ");
                wordsList.remove(targetRev);
                result += 4;
            } else if (!hasOneDoubleString && target.charAt(0) == target.charAt(1)) {
                // System.out.println("Found a double string: " + target);
                hasOneDoubleString = true; // we have at least one double string
            }
        }
        // System.out.println(sb.toString());
        // System.out.println(hasOneDoubleString);
        if (hasOneDoubleString) {
            return result + 2;
        } else {
            return result;
        }
    }

    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {// if the current element is not equal to the previous one
                i++;// it means we have found a new element, so we need to increment the index
                nums[i] = nums[j];// assign the current element to the next position
            }
        }
        return i + 1;

    }

    /**
     * https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/
     * 
     * @param s
     * @return
     */
    public List<String> cellsInRange(String s) {
        String start = s.split(":")[0];
        String end = s.split(":")[1];
        // Character startChar = start.charAt(0);
        // int startIndex = Character.getNumericValue(start.charAt(1));//
        // https://www.scaler.com/topics/char-to-int-in-java/;
        // Character endChar = end.charAt(0);
        // int endIndex = end.charAt(1) - '0';//
        // https://www.scaler.com/topics/char-to-int-in-java/;
        // System.out.println(startChar + "," + startIndex + "," + endChar + "," +
        // endIndex);

        List<String> result = new ArrayList<String>();
        // int columRange = endChar - startChar;
        // int rowRange = endIndex - startIndex;
        // System.out.println(columRange + "," + rowRange);
        for (Character col = start.charAt(0); col <= end.charAt(0); col++) {
            for (int row = start.charAt(1) - '0'; row <= end.charAt(1) - '0'; row++) {
                // System.out.println(col+""+row);
                result.add(col + "" + row);
            }

        }
        System.out.println(result);
        return result;
    }

    /**
     * https://leetcode.com/problems/append-k-integers-with-minimal-sum/
     * 
     * @param nums
     * @param k
     * @return
     */
    public long minimalKSum(int[] nums, int k) {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int value = 1;
        while (k > 0) {
            if (list.contains(value)) {
                value++;
            } else {
                result += value;
                System.out.println(value);
                k--;
                value++;
            }
        }
        return 0;
    }

    /**
     * 
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        Set<Integer> sets = new TreeSet<>();
        for (int i : nums) {
            sets.add(i);
        }
        int compare = 1;
        System.out.print(sets.size() + "" + nums.length);
        while (compare < sets.size()) {
            if (sets.contains(compare)) {
                compare++;
            } else
                return compare;
        }
        return sets.size() + 1;
    }

    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        System.out.println(Arrays.toString(sArray) + "," + Arrays.toString(tArray));
        System.out.println(Arrays.equals(sArray, tArray));
        return sArray == tArray;
    }

    public int myAtoi(String s) {

        s = s.trim();
        if (s == null || s.length() == 0) {
            return 0;
        }
        // System.out.println( s.charAt(0));
        if (s.charAt(0) != '-' && s.charAt(0) != '+' && !Character.isDigit(s.charAt(0))) {
            return 0;
        }
        int i = 1;
        char positiveNegative = s.charAt(0);
        if (positiveNegative == '-')
            i = -1;

        System.out.println("positiveNegative: " + i);
        s = s.replaceAll("[^0-9]", "");
        System.out.println(s);

        // s = s.replaceAll("[^0-9-+]", "");
        Double result;
        try {
            result = Double.valueOf(s);
            System.out.println(result);
            // clamp the integer so that it remains in the range.
            result = Math.max(result, Integer.MIN_VALUE);
            result = Math.min(result, Integer.MAX_VALUE);
        } catch (Exception e) {
            return 0;
        }
        // make sure the
        return result.intValue() * i;
    }

    /*
     * public String longestCommonPrefix(String[] strs) {
     * String result = "";
     * String base = strs[0];
     * int minLength = 201;
     * // 1. get the shortest string
     * for (String string : strs) {
     * if (string.length() < minLength) {
     * base = string;
     * minLength = string.length();
     * }
     * }
     * System.out.println("base: " + base);
     * 
     * String sbString = "";
     * int correctCount = 0;
     * // iterate the subString
     * for (int i = 0; i < base.length(); i++) {
     * correctCount = 0;
     * sbString = base.substring(i, base.length());
     * System.out.println(sbString);
     * for (String string : strs) {
     * if (!string.contains(sbString)) {
     * break;
     * } else {
     * correctCount++;
     * }
     * }
     * if (correctCount == strs.length) {
     * result = sbString;
     * System.out.println("find one:" + result);
     * break;
     * }
     * }
     * 
     * for (int i = base.length(); i > 0; i--) {
     * correctCount = 0;
     * sbString = base.substring(0, i);
     * System.out.println(sbString);
     * for (String string : strs) {
     * if (!string.contains(sbString)) {
     * 
     * break;
     * } else {
     * correctCount++;
     * }
     * }
     * if (correctCount == strs.length) {
     * result = sbString;
     * System.out.println("find one:" + result);
     * break;
     * }
     * }
     * 
     * return result;
     * }
     */
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        String base = strs[0];

        System.out.println("base: " + base);

        String sbString = "";
        int correctCount = 0;
        // iterate the subString
        for (int i = 0; i <= base.length(); i++) {
            correctCount = 0;
            sbString = base.substring(0, i);
            System.out.println(sbString);
            for (String string : strs) {
                if (!string.startsWith(sbString)) {
                    break;
                } else {
                    correctCount++;
                }
            }
            if (correctCount == strs.length && sbString.length() > result.length()) {
                result = sbString;
                System.out.println("find one:" + result);

            }
        }

        return result;
    }

    public int maxArea(int[] height) {
        // int max = 0;
        // for (int i = 0; i < height.length; i++) {
        // for (int j = i + 1; j < height.length; j++) {
        // int w = j - i;
        // int h = Math.min(height[i], height[j]);
        // int area = w * h;
        // max = Math.max(max, area);
        // }
        // better solution: two pointers
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = h * w;
            max = Math.max(max, area);
            if (height[left] < height[right])
                left++;// move the shorter line
            else if (height[left] > height[right])
                right--;// move the shorter line
            else {
                left++;
                right--;
            }
        }
        return max;
    }

    public boolean checkPalindromeFormation(String a, String b) {
        int index = 0;
        while (index < a.length()) {
            // System.out.println("index: " + index);
            String aPrefix = a.substring(0, index);
            String aSuffix = a.substring(index, a.length());
            String bPrefix = b.substring(0, index);
            String bSuffix = b.substring(index, b.length());
            // System.out.println("aPrefix: " + aPrefix + " aSuffix: " + aSuffix);
            String A = aPrefix + bSuffix;
            String B = bPrefix + aSuffix;
            System.out.println("A: " + A + " B: " + B);
            // Below step will cost a lot of time, the fact is that we don't need to reverse
            String a_RevString = new StringBuilder(A).reverse().toString();
            String b_RevString = new StringBuilder(B).reverse().toString();
            if (A.equals(a_RevString) || B.equals(b_RevString)) {
                return true;
            }
            index++;
        }
        return false;
    }
    // A better solution：
    // public boolean checkPalindromeFormation(String a, String b) {
    // return check(a, b) || check(b, a);
    // }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j && s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
        }
        return i >= j;
    }

    boolean check(String a, String b) {
        int i = 0, j = a.length() - 1;
        while (i < j && a.charAt(i) == b.charAt(j)) {
            ++i;
            --j;
        }
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

    /**
     * https://leetcode.com/problems/climbing-stairs/
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can
     * you climb to the top?
     * 
     * @param n the number of stairs
     * @return the number of distinct ways to climb to the top
     */
    public int climbStairs(int n) {

        // int[] dp = new int[n + 1];
        // dp[0] = 1;
        // dp[1] = 1;
        // for (int i = 2; i <= n; i++) {
        // dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];

        // better solution: Fibonacci number
        if (n == 1)
            return 1;
        // nomatter how many stairs, the first step is always 1 or 2 steps
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= n; i++) {
            // the next step is the sum of the previous two steps(n-1) or (n-2), so sum them
            third = first + second;
            first = second;
            second = third;

        }
        return second;
    }

}

/* This class is for LeetCode test */
public class LeetCode {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // new Solution().myAtoi("-");

        System.out.println("Result: " +
                new Solution().climbStairs(3));
        long TotalTime = System.nanoTime() - startTime;
        // print total time
        System.out.println("Total Time: " + TotalTime / 1000000 + "ms | " + TotalTime + " nanos");
    }
}
