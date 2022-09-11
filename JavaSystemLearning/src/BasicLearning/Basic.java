package BasicLearning;

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
        // JavaString javaString = new JavaString();

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
        private String myString = "  Hello World ";

        public JavaString() {
            System.out.println("--------------------");
            simpleString();
            stringLength();
            stringUpperCase();
            stringLowerCase();
            stringConcat();
            stringTrim();
            stringIndexOf();
            stringSubstring();
            stringReplace();
            stringSplit();
            System.out.println("--------------------");
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
        }

        public void stringSplit() {
            String[] myStringArray = myString.split(" ");// split by space,ignore end space
            for (String string : myStringArray) {
                System.out.println(myStringArray.length + string);
            }
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
}
