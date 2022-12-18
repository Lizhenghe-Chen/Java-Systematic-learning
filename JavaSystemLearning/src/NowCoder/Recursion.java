package NowCoder;

public class Recursion {
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