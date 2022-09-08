package BasicLearning;

public class Basic {
    public static void main(String[] args) throws Exception {
        Variables.JavaVariables();
    }

    static class Variables extends Basic {
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

    static class DataTypes extends Variables {
        /**
         * Data types are divided into two groups:
         * Primitive data types - includes byte, short, int, long, float, double,
         * boolean and char
         * Non-primitive data types - such as String, Arrays and Classes
         * https://www.w3schools.com/java/java_data_types.asp
         */
        public static void JavaDataTypes() {
            JavaVariables();
        }
    }

    
   
}
