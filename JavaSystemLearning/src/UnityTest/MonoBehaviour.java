package UnityTest;

public class MonoBehaviour {
    float myNum = 0; // local variable
    Boolean loop = true;

    /** this should be similar to the update function in unity */
    public void UnityUpdate() {
        while (loop) {
            try {
                Update();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            } finally {
                UnityUpdate();
            }

        }
    }

    private void Update() {
        // just like the unity update function, this function will be called every frame
        if (myNum > 50000) {
            System.out.println("Done");
            loop = false;
        }
        // int a = "";
        System.out.println(myNum++);
        // clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }
}
