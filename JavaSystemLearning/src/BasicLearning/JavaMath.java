package BasicLearning;

/**
 * The Java Math class has many methods that allows you to perform mathematical
 * tasks on numbers.
 * // https://www.w3schools.com/java/java_math.asp
 */
public class JavaMath extends Basic {
    public JavaMath() {
        System.out.println(Math.max(5, 10)); // Outputs 10;
        System.out.println(Math.min(5, 10)); // Outputs 5;
        System.out.println(Math.sqrt(64)); // Outputs 8;
        System.out.println(Math.abs(-4.7)); // Outputs 4.7;
        System.out.println(Math.random()); // Outputs a random number between 0.0 and 1.0;
        System.out.println(Math.random() * 100); // Outputs a random number between 0.0 and 100.0;
        System.out.println(Math.round(4.7)); // Outputs 5;
        System.out.println(Math.ceil(4.4)); // Outputs 5;
        System.out.println(Math.floor(4.7)); // Outputs 4;
        System.out.println(Math.PI); // Outputs 3.141592653589793;
        System.out.println(Math.E); // Outputs 2.718281828459045;

    }
}
