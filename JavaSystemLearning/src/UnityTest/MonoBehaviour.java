package UnityTest;

public class MonoBehaviour {
    float myNum = 0; // local variable

    /** this should be similar to the update function in unity */
    public void UnityUpdate() {
        while (Update()) {
        }
    }

    private boolean Update() {
        if (myNum > 5000) {
            System.out.println("Done");
            return false;
        }
        System.out.println(myNum++);
        // clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return true;

    }
}
