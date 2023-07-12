package MyTools;

import java.math.BigDecimal;

/**
 * A class contains some useful tools like
 * <ul>
 * <li>PrintExecutionTime</li>
 * <li>println</li>
 * <li>Colorful Println</li>
 * </ul>
 * <
 * 
 * @author Lizhenghe.Chen
 */
public class PrintTools {
    public static final String ANSI_Normal = "\u001B[0m";// normal
    public static final String ANSI_Red = "\u001B[31m";// red
    public static final String ANSI_Green = "\u001B[32m";// green
    public static final String ANSI_Yellow = "\u001B[33m";// yellow
    public static final String ANSI_Blue = "\u001B[34m";// blue
    public static final String ANSI_Purple = "\u001B[35m";// purple
    public static final String ANSI_Cyan = "\u001B[36m";// cyan
    public static final String ANSI_White = "\u001B[37m";// white
    public static final String ANSI_Black = "\u001B[30m";// black
    public static final String ANSI_Pink = "\u001B[95m";// pink
    public static final String ANSI_RESET = "\u001B[0m"; // reset

    public static void PrintExecutionTime(long globalStartTime) {
        long TotalTime = System.nanoTime() - globalStartTime;
        // print total time
        println("Time costs: " + TotalTime / 1000000 + "ms | " + TotalTime + " nanos");
        // chang the original
        globalStartTime = System.nanoTime();
        // Print(String.valueOf(globalStartTime));
    }

    public static void PrintExecutionTime(BigDecimal globalStartTime) {
        BigDecimal TotalTime = new BigDecimal(System.nanoTime()).subtract(globalStartTime);
        // print total time
        println("Time costs: " + TotalTime.divide(new BigDecimal(1000000)) + "ms | " + TotalTime + " nanos");
        // chang the original
        globalStartTime = new BigDecimal(System.nanoTime());
        // Print(String.valueOf(globalStartTime));
    }

    public static void PrintExecutionTime(String flag, long globalStartTime) {
        long TotalTime = System.nanoTime() - globalStartTime;
        // print total time
        println(flag + "-> " + TotalTime / 1000000 + "ms | " + TotalTime + " nanos");
        // chang the original
        globalStartTime = System.nanoTime();
        // Print(String.valueOf(globalStartTime));
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void println(String str, String color) {
        System.out.println(color + str + ANSI_Normal);
    }

    public static void println(int str) {
        System.out.println(str);
    }

    public static void println(long str) {
        System.out.println(str);
    }

    public static void println(double str) {
        System.out.println(str);
    }

    public static void println(boolean str) {
        System.out.println(str);
    }

    public static void println(char str) {
        System.out.println(str);
    }

    public static void println(Object str) {
        System.out.println(str);
    }

}
