package BasicLearning;

import MyTools.PrintTools;

public class Variables extends Basic {
    /**
     * In Java, there are different types of variables, for example:
     * 
     * String - stores text, such as "Hello". String values are surrounded by double
     * quotes
     * int - stores integers (whole numbers), without decimals, such as 123 or -123
     * float - stores floating point numbers, with decimals, such as 19.99 or -19.99
     * char - stores single characters, such as 'a' or 'B'. Char values are
     * surrounded by single quotes
     * boolean - stores values with two states: true or false
     * https://www.w3schools.com/java/java_variables.asp
     */
    public static void main(String[] args) {
        int[] array = {10};
        tripleValue(array);
        System.out.println(array[0]);
    }
    
    public static void tripleValue(int[] array) {
        array[0] = 3 * array[0];
    }
    public static void JavaVariables() {
        // // Java String:
        // String greeting = "Hello World";
        // System.out.println(greeting);
        // // Java int:
        // int myNum = 5;
        // System.out.println(myNum);
        // // Java float:
        // float myFloatNum = 5.9900f;
        // System.out.println(myFloatNum);
        // // Java char:
        // char myLetter = 'D';
        // System.out.println(myLetter);
        // // Java boolean:
        // boolean myBool = true;
        // System.out.println(myBool);
        // PrintTools.println(Integer.toHexString(111));;

    }

    public static void VariablesBound() {
        PrintTools.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        PrintTools.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        PrintTools.println("BigInteger.MAX_VALUE: " + java.math.BigInteger.valueOf(Long.MAX_VALUE));
        PrintTools.println("BigInteger.MIN_VALUE: " + java.math.BigInteger.valueOf(Long.MIN_VALUE));
        PrintTools.println("Double.MAX_VALUE: " + Double.MAX_VALUE);
        PrintTools.println("Double.MIN_VALUE: " + Double.MIN_VALUE);
        PrintTools.println("Float.MAX_VALUE: " + Float.MAX_VALUE);
        PrintTools.println("Float.MIN_VALUE: " + Float.MIN_VALUE);
        PrintTools.println("Long.MAX_VALUE: " + Long.MAX_VALUE);
        PrintTools.println("Long.MIN_VALUE: " + Long.MIN_VALUE);
        PrintTools.println("Short.MAX_VALUE: " + Short.MAX_VALUE);
        PrintTools.println("Short.MIN_VALUE: " + Short.MIN_VALUE);
        PrintTools.println("Byte.MAX_VALUE: " + Byte.MAX_VALUE);
        PrintTools.println("Byte.MIN_VALUE: " + Byte.MIN_VALUE);

    }

    /**
     * Get the prime number from 1 to n
     * 
     * @param n
     */
    public static void PrimeNumber(int n) {
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {// from 2 to sqrt(i), if i can be divided by j, then i is not a prime
                                              // number
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }

}