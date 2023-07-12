package JavaObject;

import MyTools.PrintTools;

/**
 * public ->The class is accessible in any package in the program.
 * protected ->The class is accessible in the package and in subclasses of the
 * class.
 * default ->Accessible only in the package where the class is defined.
 * private ->Cannot be accessed from an external class at all even if they are
 * in same package or different package.
 */
class ExampleClass implements Cloneable {
    protected int ID;
    protected String name;
    protected int value;
    String comment;
    public static String staticField = "staticField";
    InnerClass innerClass = new InnerClass(1, 1);

    public ExampleClass(int ID, String name, int value) {
        this.ID = ID;
        this.name = name;
        this.value = value;
        this.comment = null;
    }

    @Override
    public String toString() {
        return "===\n" + "ID: " + ID + "\nname: " + name + "\nvalue: " + value + "\ncomment: " + comment +
                "\ninnerClass: " + innerClass.toString();
    }

    @Override
    protected ExampleClass clone() throws CloneNotSupportedException {
        ExampleClass cloned = (ExampleClass) super.clone();
        cloned.comment = "cloned";
        PrintTools.println("Successfully cloned", MyTools.PrintTools.ANSI_Green);
        return cloned;
    }

    class InnerClass {
        int x, y;

        InnerClass(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x: " + x + ", y: " + y;
        }
    }
}
