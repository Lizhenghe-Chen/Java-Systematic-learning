package JavaLambda;

import java.util.function.*;
import java.util.*;
import MyTools.*;

public class Functions {
    public static void main(String[] args) {

        Predicate<Integer> isEven = isEvenFunctions();
        PrintTools.println(isEven.test(2));

        Function<String, String> SbuStringUntil_5 = str -> str.substring(0, 5);
        PrintTools.println(SbuStringUntil_5.apply("HelloWorld!"));
    }

    /**
     * Predicate is a functional interface, which means it can be used as the
     * assignment of a lambda expression.
     * <Integer> means the parameter is Integer.
     * 
     * @return
     */
    public static Predicate<Integer> isEvenFunctions() {
        return x -> x % 2 == 0;
    }

    /**
     * Function is a functional interface, which means it can be used as the
     * assignment of a lambda expression.
     * <String, String> means the first parameter is String, and the return value
     * 
     * @param num The index of the last character to be returned.
     * @return
     */
    public static Function<String, String> SbuStringUntil(int num) {
        return str -> str.substring(0, num);
    }

    /**
     * BiFunction is a functional interface, which means it can be used as the
     * assignment of a lambda expression.
     * <String, Integer, String> means the first parameter is String, the second is
     * Integer, and the return value is String.
     * 
     * @return
     */
    public static BiFunction<String, Integer, String> SubStringUntil_Num() {
        return (str, num) -> str.substring(0, num);
    }
}
