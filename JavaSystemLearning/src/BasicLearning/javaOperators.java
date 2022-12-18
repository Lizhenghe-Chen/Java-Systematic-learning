package BasicLearning;

public class javaOperators extends Basic {
    /**
     * Java has the following types of operators:
     * Arithmetic operators: +, -, *, /, %, ++, --
     * Assignment operators: =, +=, -=, *=, /=, %=
     * Comparison operators: ==, !=, >, <, >=, <=
     * Logical operators: &&, ||, !
     * Bitwise operators: ~ >> << >>>
     * https://www.w3schools.com/java/java_operators.asp
     */
    public static void JavaOperators() {
        int x = 5, y = 10;
        // System.out.println(x + y); // Outputs 15 (5 + 10)
        // System.out.println(x - y); // Outputs -5 (5 - 10)
        // System.out.println(x * y); // Outputs 50 (5 * 10)
        // System.out.println(x / y); // Outputs 0 (5 / 10)
        // System.out.println(x % y); // Outputs 5 (5 % 10)
        // x = 5;
        // y = 10;
        // System.out.println(x++); // Outputs 5 (output then 5 + 1)
        // x = 5;
        // y = 10;
        // System.out.println(x--); // Outputs 5 (output then 6 - 1)
        // x = 5;
        // y = 10;
        // System.out.println(++x); // Outputs 6 (5 + 1 then output )
        // x = 5;
        // y = 10;
        // System.out.println(--x); // Outputs 4 (5 - 1 then output )
        // x = 5;
        // y = 10;
        // System.out.println(x += y); // Outputs 15 (5 + 10 then output)
        // x = 5;
        // y = 10;
        // System.out.println((x = +y) + " " + x); // Outputs 10 (x = +10)
        // x = 5;
        // y = 10;
        // System.out.println(x -= y); // Outputs -5 (5 - 10)
        // x = 5;
        // y = 10;
        // System.out.println(x *= y); // Outputs 50 (5 * 10)
        // x = 5;
        // y = 10;
        // System.out.println(x /= y); // Outputs 0 (5 / 10 = 0.5 =~ 0)
        // x = 5;
        // y = 10;
        // System.out.println(y %= 5); // Outputs 0 (10 % 5 = 2 * 5 + 0)
        // System.out.println(x == y); // Outputs false (5 == 10)
        // System.out.println(x != y); // Outputs true (5 != 10)
        // System.out.println(x > y); // Outputs false (5 > 10)
        // System.out.println(x <= y); // Outputs true (5 <= 10)
        // System.out.println(!(x == y)); // Outputs true (!(5 == 10))
        // System.out.println(x & y); // Outputs 0 (5 & 10)
        // System.out.println(x | y); // Outputs 15 (5 | 10)
        System.out.println(x ^ y); // Outputs 15 (5 ^ 10)
        System.out.println(~3); // Outputs -4 (~3)
        // 0011=3 after ~:
        // 1100=4
        // Signed left shift operator
        System.out.println(x << 2); // Outputs 20 (5 << 2)
        // 00000101=5 after <<2: move 2 bits to the left
        // 00010100=20
        System.out.println(x >> 1); // Outputs 2 (5 >> 1)
        // 00000101=5 after >>1: move 1 bit to the right
        // 00000010=2
        // Unsigned right shift operator
        System.out.println(x >>> 1); // Outputs 2 (5 >>> 1)
        // 00000101=5 after >>>1: move 1 bit to the right
        // 00000010=2
        System.out.println(-x >>> 2); // Outputs 1073741822 (-5 >>> 2)
        // 11111111111111111111111111111011=-5 after >>>2: move 2 bits to the right
        // 00111111111111111111111111111110=1073741822

    }
}