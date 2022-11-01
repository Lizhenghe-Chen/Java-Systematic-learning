package BasicLearning;

/**
 * Use if to specify a block of code to be executed, if a specified condition is
 * true
 * Use else to specify a block of code to be executed, if the same condition is
 * false
 * Use else if to specify a new condition to test, if the first condition is
 * false
 * Use switch to specify many alternative blocks of code to be executed
 */
public class JavaStatements {
    private static int a = 10, b = 20, c = 30;
    private static int[] numbersA = { 1, 2, 3, 4, 10 };

    public static void main(String[] args) {

        // IfElseStatement();
        // IfElseIfStatement();
        // SwitchStatement();
        // WhileStatement();
        // DoWhileStatement();
        // ForStatement();
        // ForEachStatement();
        // BreakStatement();
        // ContinueStatement();
        LabelStatement();
    }

    /**
     * Use if to specify a block of code to be executed
     */
    static void IfElseStatement() {
        if (a == 10) {
            System.out.println("a is 10");
        } else {
            System.out.println("a is not 10");
        }
    }

    /**
     * Use else if to specify a new condition to test, if the first condition is
     * false
     */
    static void IfElseIfStatement() {
        if (a == 10) {
            System.out.println("a is 10");
        } else if (b == 20) {
            System.out.println("b is 20");
        } else {
            System.out.println("a and b are not 10 and 20");
        }
    }

    /**
     * Use switch to specify many alternative blocks of code to be executed
     */
    static void SwitchStatement() {
        int day = 4;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }
    }

    /**
     * 
     */
    static void WhileStatement() {
        int i = 0;
        while (i <= c) {
            System.out.println(i);
            i++;
        }
    }

    /**
     * Difference between while, do while process the code blick first, then check
     * the condition
     */
    static void DoWhileStatement() {
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i <= c);
    }

    static void ForStatement() {
        for (int i = 0; i <= c; i++) {
            System.out.println(i);
        }
    }

    /**
     * foreach is a simple version of for loop
     */
    static void ForEachStatement() {

        for (int x : numbersA) {
            System.out.print(x);
            System.out.print(",");
        }
    }

    /**
     * break statement can be used to jump out of a loop
     */
    static void BreakStatement() {
        for (int i = 0; i <= c; i++) {
            if (i == 20) {
                break;
            }
            System.out.println(i);
        }
    }

    /**
     * continue statement can be used to jump to the next iteration of a loop
     */
    static void ContinueStatement() {
        for (int i = 0; i <= 20; i++) {
            if (i == 10) {
                continue; // skip current process, continue to next loop, which means it will not print 10
            }
            System.out.println(i);
        }
    }

    /**
     * label statement can be used to jump to or break a labeled code block
     * Java does not have a general statement.goto
     * The statements and in Java alter the normal control flow of control flow
     * statements. They can use labels which are valid java identifiers with a
     * colon.breakcontinue
     * Labeled blocks can only be used with and statements.breakcontinue
     * Labaled and statements must be called within its scope. We can not refer them
     * outside the scope of labeled block.breakcontinue
     * The statement immediately jumps to the end (and out) of the appropriate
     * compound statement.break
     * The statement immediately jumps to the next iteration (if any) of the
     * appropriate loop.continue
     * A statement does not apply to a switch statement or a block statement, only
     * to compound statements e.g. for-loop, while-loop, and do-while loop.continue
     */
    static void LabelStatement() {
        int[] numbersB = { 10, 20, 30, 40, 50 };
        loop1: for (int temp1 : numbersA) {
            loop2: for (int temp2 : numbersB) {
                if (temp1 == temp2) {

                    // use indexOf
                    System.out.println("temp1: " + temp1 + " temp2: " + temp2);
                    break loop2;
                    // continue loop3; this will cause error since loop3 is out of scope
                }
            }
        }
        loop3: for (int i : numbersB) {
            System.out.println(i);
        }
    }

        

}
