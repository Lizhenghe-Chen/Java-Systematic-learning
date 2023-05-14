package MyTools;

public class Tools {
    public static void PrintExecutionTime(long globalStartTime) {
        long TotalTime = System.nanoTime() - globalStartTime;
        // print total time
        println("Time costs: " + TotalTime / 1000000 + "ms | " + TotalTime + " nanos");
        // chang the original
        globalStartTime = System.nanoTime();
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
