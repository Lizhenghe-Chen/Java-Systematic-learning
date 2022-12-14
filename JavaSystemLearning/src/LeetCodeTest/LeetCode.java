package LeetCodeTest;

import java.util.*;

/* This class is for LeetCode test */
public class LeetCode {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        new Solution().ShiftofCoordinates();

        long TotalTime = System.nanoTime() - startTime;
        // print total time
        System.out.println("Total Time: " + TotalTime / 1000000 + "ms | " + TotalTime + " nanos");
    }
}

class Solution {
    public void ShiftofCoordinates() {
        ShiftofCoordinates("A1;A10;");
    }

    private void ShiftofCoordinates(String inputString) {
        int[] total = { 0, 0 };

        String[] stringList = inputString.split(";");
        // System.out.println("stringList: " + Arrays.toString(stringList));
        for (String temp : stringList) {
            Caculate(temp, total);
        }
        System.out.println("total: " + Arrays.toString(total));
    }

    private void Caculate(String input, int[] total) {
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

    private int searchInsert(int[] nums, int target) {
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
    private void reverseString(char[] s) {

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

    private int reverseInteger(int x) {

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

    private int firstUniqChar(String s) {
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

    private int[] twoSum(int[] nums, int target) {
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

    private String intToRoman(int num) {
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

    private boolean isPalindrome(int x) {
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
    private boolean isSentencePalindrome(String s) {
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
    private int longestPalindrome(String[] words) {
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
}
