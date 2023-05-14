package BasicLearning;

import java.util.Arrays;

public class JavaString extends Variables {
    private String myString = "  Hello World! ";

    public static void main(String[] args) {
        System.out.println("--------------------");
        String[] temp = "asdasd    asdasfa ".split("");
        for (String string : temp) {

            System.out.print(string);
            System.out.println(string.matches(" "));
        }
        // simpleString();
        // stringLength();
        // stringUpperCase();
        // stringLowerCase();
        // stringConcat();
        // stringTrim();
        // stringIndexOf();
        // StringtoCharArray();
        // stringSubstring();
        // stringReplace();
        // stringSplit();
        // stringInvert();
        // stringInvertWithBuilder();
        // JavaArrays.JavaArraysTest();
        // stringSplitWithRegex();
        // ContainsAnyOutOfCharList("Hello ButterFly", "[^BF]");
        // stringMatch();
        // String containStr = "[ABCD]";
        // System.out.println(ContainsAnyOutOfCharList(myString, containStr));

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
        System.out.println("concat String: " + myString.concat("!!!" + null));//
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

    public void StringtoCharArray() {
        char[] myCharArray = myString.toCharArray();
        System.out.println(Arrays.toString(myCharArray));
    }

    public void stringIndexOf() {
        // " He'l'lo World " -> 5
        System.out.println(myString.indexOf("l"));
        System.out.println(myString.indexOf("l", 6));
        System.out.println(myString.lastIndexOf("l"));
        System.out.println(myString.lastIndexOf("l", 11));
    }

    public void stringSubstring() {
        // "' Hel'lo World " -> " Hel"
        System.out.println(myString.substring(0, 5));
    }

    // https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
    public void stringReplace() {
        System.out.println(myString.replace("l", "d"));
        // System.out.println(myString.replaceFirst("l", "*"));
        System.out.println(myString.replaceAll("l{1,}", "*"));
        String test = "123**456**789";
        // notice that the '*' is a special char in regex, so we need to use '\\*'
        System.out.println(test.replaceAll("\\*{1,}", ","));
    }

    public void stringSplit() {
        String[] myStringArray = myString.split(" ");// split by space, but ignore end space!
        String[] myStringArray2 = myString.split(" ", 2);// split string to 2 parts, but ignore end space!

        System.out.println(Arrays.toString(myStringArray2));

    }

    /** https://www.w3schools.com/java/java_regex.asp */
    public void stringSplitWithRegex() {
        String[] myStringArray = myString.split("\\s+");// '\\s+' means split by any space, ' ',' ', similar to \\s{1,}
        // myStringArray = myString.split("l{1,}");// split by any l
        for (String string : myStringArray) {
            System.out.println(myStringArray.length + string);
        }
        String test = "123,456,789";
        System.out.println(Arrays.toString("Hello12Wor34ld555".split("[0-9]+")));// '+' means 1 or more
    }

    /**
     * This function is used to check if the string contains any char out of the
     * char list
     * 
     * @param targetStr
     * @param charList
     */
    private void ContainsAnyOutOfCharList(String targetStr, String charList) {
        // System.out.println(targetStr.contains(charList));
        String temp = targetStr.replaceAll(charList, "");// repalce
        System.out.println(temp + ", " + temp.equals(targetStr));
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

    public void stringMatch() {
        System.out.println(myString.matches("Hello World"));
        System.out.println(myString.matches("(.*)World(.*)"));
        System.out.println(myString.matches("(.*)Hello(.*)"));// " Hello World! "
    }

    public String RemoveDulicateChar(String str) {
        String[] strArray = str.split("");
        String result = "";
        for (String string : strArray) {
            if (!result.contains(string)) {
                result += string;
            }
        }
        // if string is empty, return null
        if (result.length() == 0) {
            return null;
        }
        return result;
    }

}