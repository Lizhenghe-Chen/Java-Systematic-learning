package BasicLearning;

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
 * '[^abc]': When a caret appears as the first character inside square brackets, it negates the pattern. This pattern matches any character except a or b or c.
 * '[a-d1-7]': Ranges: matches a letter between a and d and figures from 1 to 7, but not d1.
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
 * https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
 */
public class JavaRegex extends JavaString {

    public static void main(String[] args) {
        // MatchsPureTextRegex();
        MatchsWhiteSpaceTextRegex();
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
        System.out.println("Hello World!".matches("\\w\\s\\w"));// false, \\w means one word character
        System.out.println("Hello World!".matches("\\w"));// false, \\w means one word character
    }

}
