package LeetCodeTest;

/* This class is for LeetCode test */
public class LeetCode {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        new Solution().reverseInteger();

        long TotalTime = System.nanoTime() - startTime;
        // print total time
        System.out.println("Total Time: " + TotalTime / 1000000 + "ms, or " + TotalTime + " nanos");
    }
}

class Solution {
    public void reverseString() {
        char myChar[] = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(myChar);
    }

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
}
