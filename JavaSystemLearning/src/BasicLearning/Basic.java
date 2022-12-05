package BasicLearning;

import java.util.Arrays;

/**
 * This java file includes some basic knowledge of java
 * such as: variable, array, loop, if-else, switch, function, class, object,
 * etc.
 */
public class Basic {
    public static void main(String[] args) {
        // Variables.JavaVariables();
        // Variables.TypeCast.JavaTypeCast();
        // Operators.JavaOperators();
         new JavaString();
       // new JavaMath();
        // JavaArrays.JavaArraysSort();
    }

    public static class Variables extends Basic {
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
        public static void JavaVariables() {
            // Java String:
            String greeting = "Hello World";
            System.out.println(greeting);
            // Java int:
            int myNum = 5;
            System.out.println(myNum);
            // Java float:
            float myFloatNum = 5.99f;
            System.out.println(myFloatNum);
            // Java char:
            char myLetter = 'D';
            System.out.println(myLetter);
            // Java boolean:
            boolean myBool = true;
            System.out.println(myBool);
        }
    }

    public static class JavaString extends Variables {
        private String myString = "  Hello World! ";

        public JavaString() {
            System.out.println("--------------------");
            // simpleString();
            // stringLength();
            // stringUpperCase();
            // stringLowerCase();
            // stringConcat();
            // stringTrim();
            // stringIndexOf();
            // stringSubstring();
          //  stringReplace();
            // stringSplit();
            // stringInvert();
            // JavaArrays.JavaArraysTest();
            stringSplitWithRegex();
          //  stringMatch();
            // String containStr = "[ABCD]";
            // System.out.println(ContainsAnyOutOfCharList(myString, containStr));
            System.out.println("--------------------");
        }

        /**
         * This function is used to check if the string contains any char out of the
         * char list
         * 
         * @param targetStr
         * @param charList
         */
        private Boolean ContainsAnyOutOfCharList(String targetStr, String charList) {
            // System.out.println(targetStr.replaceAll("[ABCD]", ""));
            String temp = targetStr.replaceAll("[^ABCD]", "");
            return temp.equals(targetStr);
        }

        private void stringInvert() {
            for (int i = myString.length() - 1; i >= 0; i--) {
                System.out.print(myString.charAt(i));
            }
            System.out.println();
        }

        private void stringInvertWithBuilder() {
            System.out.println(new StringBuilder(myString).reverse());
        }

        /**
         * A String variable contains a collection of characters surrounded by double
         * quotes:
         */
        public void simpleString() {

            System.out.println("simple String: " + myString);
        }

        public void stringLength() {
            System.out.println("Length of String: " + myString.length());
        }

        public void stringUpperCase() {
            System.out.println("UpperCase String: " + myString.toUpperCase());
        }

        public void stringLowerCase() {
            System.out.println("LowerCase String: " + myString.toLowerCase());
        }

        /** string.concat() is more strict than "+" */
        public void stringConcat() {
            System.out.println("concat String: " + myString.concat("!!!" + null));
            // System.out.println(myString.concat(null));//this will throw an exception
        }

        /**
         * remove any white space before and after the string
         */
        public void stringTrim() {
            System.out.println("Trim String: " + myString.trim());
        }

        public void stringCharAt() {
            System.out.println(myString.charAt(0));
        }

        public void stringIndexOf() {
            // " He'l'lo World " -> 5
            System.out.println(myString.indexOf("l"));
        }

        public void stringSubstring() {
            // " Hel'lo World " -> " Hel"
            System.out.println(myString.substring(0, 5));
        }

        public void stringReplace() {
            System.out.println(myString.replace("l", "d"));
            System.out.println(myString.replaceFirst("l", "*"));
            System.out.println(myString.replaceAll("l{1,}", "*"));
            String test = "123**456**789";
            System.out.println(test.replaceAll("\\*{1,}", ","));//
        }

        public void stringSplit() {
            String[] myStringArray = myString.split(" ");// split by space,ignore end space
            System.out.println(Arrays.toString(myStringArray));

        }

        /** https://www.w3schools.com/java/java_regex.asp */
        public void stringSplitWithRegex() {
            String[] myStringArray = myString.split("\\s+");// split by space,ignore end space
            // myStringArray = myString.split("l{1,}");// split by any l
            for (String string : myStringArray) {
                System.out.println(myStringArray.length + string);
            }
            String test ="123,456,789";
            System.out.println(test.indexOf("[0-9]{1,}")) ;
        }

        public void stringMatch() {
            System.out.println(myString.matches("Hello World"));
            System.out.println(myString.matches("(.*)World(.*)"));
        }

    }

    public static class DataTypes extends Variables {
        /**
         * Data types are divided into two groups:
         * Primitive data types
         * - includes byte, short, int, long, float, double, boolean and char
         * Non-primitive data types - such as String, Arrays and Classes
         * https://www.w3schools.com/java/java_data_types.asp
         */
        public static void JavaDataTypes() {
            JavaVariables();
        }
    }

    public static class TypeCast extends DataTypes {
        /**
         * Type casting is when you assign a value of one primitive data type to another
         * type.
         * There are two types of casting:
         * Widening Casting (automatically) - converting a smaller type to a larger type
         * size
         * byte -> short -> char -> int -> long -> float -> double
         * Narrowing Casting (manually) - converting a larger type to a smaller size
         * type
         * double -> float -> long -> int -> char -> short -> byte
         * https://www.w3schools.com/java/java_type_casting.asp
         */
        public static void JavaTypeCast() {
            double myDouble = 9.78d;
            System.out.println((int) myDouble); // Outputs 9
            // double to string
            System.out.println((Double.toString(myDouble))); // Outputs 9.78 as string
            System.out.println(Integer.parseInt("asd"));//
            System.out.println(Integer.valueOf("123"));
            System.out.println(Double.valueOf("123.456"));
            System.out.println(Double.parseDouble("123.456"));
        }
    }

    public static class Operators extends Basic {
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
            System.out.println(x + y); // Outputs 15 (5 + 10)
            System.out.println(x - y); // Outputs -5 (5 - 10)
            System.out.println(x * y); // Outputs 50 (5 * 10)
            System.out.println(x / y); // Outputs 0 (5 / 10)
            System.out.println(x % y); // Outputs 5 (5 % 10)
            x = 5;
            y = 10;
            System.out.println(x++); // Outputs 5 (output then 5 + 1)
            x = 5;
            y = 10;
            System.out.println(x--); // Outputs 5 (output then 6 - 1)
            x = 5;
            y = 10;
            System.out.println(++x); // Outputs 6 (5 + 1 then output )
            x = 5;
            y = 10;
            System.out.println(--x); // Outputs 4 (5 - 1 then output )
            x = 5;
            y = 10;
            System.out.println(x += y); // Outputs 15 (5 + 10 then output)
            x = 5;
            y = 10;
            System.out.println((x = +y) + " " + x); // Outputs 10 (x = +10)
            x = 5;
            y = 10;
            System.out.println(x -= y); // Outputs -5 (5 - 10)
            x = 5;
            y = 10;
            System.out.println(x *= y); // Outputs 50 (5 * 10)
            x = 5;
            y = 10;
            System.out.println(x /= y); // Outputs 0 (5 / 10 = 0.5 =~ 0)
            x = 5;
            y = 10;
            System.out.println(y %= 5); // Outputs 0 (10 % 5 = 2 * 5 + 0)
            System.out.println(x == y); // Outputs false (5 == 10)
            System.out.println(x != y); // Outputs true (5 != 10)
            System.out.println(x > y); // Outputs false (5 > 10)
            System.out.println(x <= y); // Outputs true (5 <= 10)
            System.out.println(!(x == y)); // Outputs true (!(5 == 10))
            System.out.println(x & y); // Outputs 0 (5 & 10)
            System.out.println(x | y); // Outputs 15 (5 | 10)
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

    /**
     * Java Arrays
     * import java.util.Arrays;
     * https://www.w3schools.com/java/java_arrays.asp
     */
    static String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };

    static class JavaArrays {

        public static void JavaArraysTest() {
            // To find out how many elements an array has, use the length property:
            System.out.println("Length: " + cars.length);
            // To change the value of a specific element, refer to the index number:
            cars[2] = "Opel";
            // To access an element in an array, refer to the index number:
            System.out.println(cars[0] + " " + cars[2]);
        }

        /**
         * You can loop through the array elements with the for loop,
         * and use the length property to specify how many times the loop should run.
         * The following example outputs all elements in the cars array:
         */
        public static void JavaArraysLoop() {
            for (int i = 0; i < cars.length; i++) {
                System.out.println(cars[i]);
            }
            // for each loop is also available
            for (String i : cars) {
                System.out.println(i);
            }
        }

        /**
         * Sorting Arrays
         * The sort() method sorts arrays in ascending order.
         */
        public static void JavaArraysSort() {
            Arrays.sort(cars);
            System.out.println(cars);// Note: this will print the address of the array since it is an return value of
                                     // the sort method.
            // To print the sorted array, you have to loop through it:
            for (String i : cars) {
                System.out.println(i);
            }
            // or you can use the toString method:
            System.out.println(Arrays.toString(cars));
        }

        // multidimensional arrays
        /**
         * A multidimensional array is an array containing one or more arrays.
         * To create a two-dimensional array, add each array within its own set of curly
         * braces:
         */
        public void MultidimensionalArrays() {
            int[][] myNumbers = { { 1, 2, 3, 4 }, { 5, 6, 7 } };
            // To access the elements of the myNumbers array, specify two indexes: one for
            // the array, and one for the element inside that array. This example accesses
            // the third element (2) in the second array (1) of myNumbers:
            int x = myNumbers[1][2];
            System.out.println(x); // Outputs 7
            // We can also use a for loop inside another for loop to get the elements of a
            // two-dimensional array (we still have to point to the two indexes):
            for (int i = 0; i < myNumbers.length; ++i) {
                for (int j = 0; j < myNumbers[i].length; ++j) {
                    System.out.println(myNumbers[i][j]);
                }
            }
        }

        public void twoSum() {
            int[] test = new int[] { 3, 3 };
            System.out.println(Arrays.toString(twoSum(test, 6)));
        }

        /**
         * Given an array of integers, return indices of the two numbers such that they
         * add up to a specific target.
         * https://leetcode.com/problems/two-sum
         * 
         * @param nums   an array of integers
         * @param target the target number
         * @return return indices of the two numbers such that they add up to target
         */
        public static int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] { i, j };
                    }
                }
            }
            return null;

            // Better Solution:
            // Map<Integer, Integer> map = new HashMap<>();
            // for (int i = 0; i < nums.length; i++) {
            // int complement = target - nums[i];
            // if (map.containsKey(complement)) {
            // return new int[] { map.get(complement), i };
            // }else
            // map.put(nums[i], i);
            // }
            // // In case there is no solution, we'll just return null
            // return null;

        }
    }

}
