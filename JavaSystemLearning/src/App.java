import UnityTest.*;
import BasicLearning.*;

/**
 * Welecome to My Simple Java Learning Area,
 * This project currently contains baisc Java Knowledge
 */
public class App {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // UnityTest();
        System.out.println("Total Time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * Unity case to discover Object and Class structure
     */
    static void UnityTest() {
        MonoBehaviour testObj = new MonoBehaviour();
        testObj.UnityUpdate();
    }

    /**
     * To use the BasicLearning package, you need to import it first.
     * then you can use the class in the package.
     */
    static void JavaBasicTest() {
      
    }

}
