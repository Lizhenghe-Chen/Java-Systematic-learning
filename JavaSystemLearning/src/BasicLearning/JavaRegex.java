package BasicLearning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import MyTools.Tools;

/**
 * A tool class for String regex and String operation
 * '.' : any character
 * '*' : zero or more times
 * '+' : one or more times
 * '?' : zero or one time
 * '^regex' : Finds regex that must match at the beginning of the line.
 * 'regex$' : Finds regex that must match at the end of the line.
 * '[abc]': Set definition, can match the letter a or b or c.
 * '[abc][vz]': Set definition, can match a or b or c followed by either v or z.
 * '[^abc]': When a caret appears as the first character inside square brackets,
 * it negates the pattern. This pattern matches any character except a or b or
 * c.
 * '[a-d1-7]': Ranges: matches a letter between a and d and figures from 1 to 7,
 * but not d1.
 * 'X|Z': Finds X or Z.
 * 'XZ': Finds X directly followed by Z.
 * 'XZ+': Finds X directly followed by at least one Z.
 * 'XZ*': Finds X directly followed by zero or more Z.
 * 'XZ?': Finds X directly followed by zero or one Z.
 * 'XZ{2}': Finds X directly followed by exactly 2 Z.
 * 'XZ{2,}': Finds X directly followed by at least 2 Z.
 * 'XZ{2,5}': Finds X directly followed by at least 2 Z but no more than 5 Z.
 * 'XZ{2,5}?': Finds X directly followed by at least 2 Z but no more than 5 Z.
 * 'X(?=Y)': Finds X only if followed by Y.
 * 'X(?!Y)': Finds X only if not followed by Y.
 * 'X|Y': Finds X or Y.
 * '\b': Finds a word boundary.
 * '\B': Finds a non-word boundary.
 * '\d': Finds a digit.
 * '\D': Finds a non-digit character.
 * '\s': Finds a whitespace character.
 * '\S': Finds a non-whitespace character.
 * '\w': Finds a word character.
 * '\W': Finds a non-word character.
 * '\n': Finds a new line character.
 * '\t': Finds a tab character.
 * '\r': Finds a carriage return character.
 * '\f': Finds a form feed character.
 * '\v': Finds a vertical tab character.
 * '\xxx': Finds the character specified by an octal number xxx.
 * '\xdd': Finds the character specified by a hexadecimal number dd.
 * 'X(?=Y)': Finds X only if followed by Y.
 * 'X(?!Y)': Finds X only if not followed by Y.
 * https://www.w3cschool.cn/regexp/x9hf1pq9.html
 * https://www.runoob.com/java/java-regular-expressions.html
 */
public class JavaRegex extends JavaString {

    public static void main(String[] args) {
        // MatchsPureTextRegex();
        //MatchsWhiteSpaceTextRegex();
         Count("cat tac act cat catcat World!", "cat");
        //
    //     FindLink(
    //     "项目仓库（注意只提供展示，部分工程文件暂时是不公开的，所以下载使用会报错）：http://github.com/Lizhenghe-Chen/Multi-Drones-Teleoperation-Interface-Systems 欢迎评论和交流");
    

}

    public static void MatchsPureTextRegex() {
        System.out.println("Hello World!".matches("Hello"));// false
        System.out.println("Hello World!".matches("Hello World!"));// true
    }

    /**
     * \w means word character, \s means white space, \d means digit, \b is the word
     * boundary.
     * <p>
     * '\\' is the representation of '\' in java , so \\w means one word character,
     * \\s means one white space, \\d means one digit, \\b is the word boundary.
     * <p>
     * \\w+ means one or more word character, \\s+ means one or more white space,
     * \\d+ means one or more digit
     */
    public static void MatchsWhiteSpaceTextRegex() {
        System.out.println("Hello World!".matches("\\w+\\s\\w+!"));// true, \\w+ means one or more word character,
        System.out.println("Hello World!".matches("\\w\\s\\w"));// false
        System.out.println("Hello World!".matches("\\w"));// false, \\w means one word character
        System.out.println("Hello      World!".matches("\\w+\\s\\w+!"));// false
        System.out.println("Hello      World!".matches("\\w+\\s+\\w+!"));// true
        System.out.println("3.1415926".matches("^\\d+(\\.\\d+)?"));// true
        System.out.println("a3.1415926".matches("^\\w+\\d+(\\.\\d+)?"));// true
    }

    /**
     * Find the link in the string, if there contains 'http://', 'https://', 'www.'
     * then return that link part
     * 
     * @param str
     */
    public static void FindLink(String str) {
        // if (str.contains("http://")) {
        //     int startIndex = str.indexOf("http://");
        //     String subStringwithStart = str.substring(startIndex);
        //     int endIndex = subStringwithStart.indexOf(" ");
        //     String link = subStringwithStart.substring(0, endIndex);
        //     Tools.println(link);
        // }
        // if (str.contains("https://")) {
        //     String link = str.substring(str.indexOf("https://"),
        //             str.indexOf("https://") + str.substring(str.indexOf("https://")).indexOf(" "));
        //     Tools.println(link);
        // }
        //use regex to find the link
        Pattern pattern = Pattern.compile("(http://|https://|www.)\\S+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            Tools.println(matcher.group());
        }
        
    }

    public static void Count(String str, String target) {
        int count = 0;
        int index = 0;
        // while (str.indexOf(target, index) != -1) {
        //     count++;
        //     index = str.indexOf(target, index) + 1;
        // }
        // Tools.println(count);
        Pattern pattern = Pattern.compile(target);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            count++;
            Tools.println(matcher.group());
        }
        Tools.println(count);
    }
}
