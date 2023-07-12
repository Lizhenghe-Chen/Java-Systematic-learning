package JavaObject;

import MyTools.PrintTools;

/** https://www.geeksforgeeks.org/clone-method-in-java-2/ */
public class InstanceCopy {
    public static void main(String[] args) {
        ShadowCopy_1();
        ShadowCopy_2();
        DeepCopy();
    }

    /**
     * Shadow copy, the copy and the original object share the same memory address.
     */
    static void ShadowCopy_1() {
        PrintTools.println("ShadowCopy_1");
        ExampleClass originObject = new ExampleClass(1, "David", 1);
        // shadow copy method 1:
        // Creating a new reference variable ob2
        // pointing to same address as originObject
        ExampleClass copiedOnject = originObject;
        copiedOnject.comment = "copied";
        // any change will be reflected in each other, even the inner class
        copiedOnject.value = 2;
        copiedOnject.innerClass.x = 2;
        PrintTools.println(originObject.toString());
        PrintTools.println(copiedOnject.toString());
    }

    static void ShadowCopy_2() {
        PrintTools.println("ShadowCopy_2");
        ExampleClass originObject = new ExampleClass(1, "David", 1);
        ExampleClass copiedOnject = null;
        // shadow copy method 2:
        // Using clone() method
        try {
            copiedOnject = originObject.clone();
        } catch (CloneNotSupportedException e) {
            PrintTools.println("CloneNotSupportedException", MyTools.PrintTools.ANSI_Red);
            e.printStackTrace();
        }
        // any change will not be reflected in each other, but the inner class will
        copiedOnject.value = 2;
        copiedOnject.innerClass.x = 2;
        PrintTools.println(originObject.toString());
        PrintTools.println(copiedOnject.toString());
    }

    static void DeepCopy() {
        PrintTools.println("DeepCopy");
        ExampleClass originObject = new ExampleClass(1, "David", 1);
        ExampleClass copiedOnject = new ExampleClass(originObject.ID, originObject.name, originObject.value);
        copiedOnject.comment = "copied";
        copiedOnject.value = 2;
        copiedOnject.innerClass.x = 2;
        // any change will not be reflected in each other,even the inner class
        PrintTools.println(originObject.toString());
        PrintTools.println(copiedOnject.toString());
    }
}