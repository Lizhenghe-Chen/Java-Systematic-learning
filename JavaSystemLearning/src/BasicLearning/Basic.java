package BasicLearning;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This java file includes some basic knowledge of java
 * such as: variable, array, loop, if-else, switch, function, class, object,
 * etc.
 */
public class Basic {
    public static void main(String[] args) {
        // Variables.JavaVariables();
        // Variables.TypeCast.JavaTypeCast();
        // javaOperators.JavaOperators();
        // new JavaString();
        // new JavaMath();
        JavaArrays.JavaArraysSort();
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
            // Arrays.sort(cars, Comparator.reverseOrder());// sort in reverse order
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

    }

}
