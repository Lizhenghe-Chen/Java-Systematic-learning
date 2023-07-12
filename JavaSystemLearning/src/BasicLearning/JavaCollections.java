package BasicLearning;

import java.util.*;

/**
 * Java List Class
 * Diagram(https://www.digitalocean.com/community/tutorials/java-list)
 * Java List interface extends Collection interface. Collection interface
 * externs Iterable interface. Some of the most used List implementation classes
 * are ArrayList, LinkedList, Vector, Stack, CopyOnWriteArrayList. AbstractList
 * provides a skeletal implementation of the List interface to reduce the effort
 * in implementing List.
 */
interface JavaIterable {

}

/**
 * 
 */
public interface JavaCollections extends JavaIterable {
    static String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
    static long startTime = System.nanoTime();

    public static void main(String[] args) {

        // JavaListTest();
        // new JavaArrayList().JavaArrayListTest();
        new JavaArrays().JavaMultiDimensionalArraysTest();
        // new JavaStack().JavaStackTest();
        // ======================================================================
        long TotalTime = System.nanoTime() - startTime;
        System.out.println("Total Time: " + TotalTime / 1000000 + "ms | " + TotalTime + " nanos");
    }

    /**
     * Arrays are used to store multiple values in a single variable, instead of
     * declaring separate variables for each value.
     */
    public class JavaArrays extends Object {
        public JavaArrays() {
            // TODO Auto-generated constructor stub
        }

        public void JavaSimpleArraysTest() {
            String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
            // System.out.println(cars[0]);
            // cars[0] = "Opel";
            // System.out.println(cars[0]);
            // System.out.println(cars.length);

            // ==== different ways to print out the array:
            // for (int i = 0; i < cars.length; i++) {
            // System.out.println(cars[i]);
            // }
            // for (String i : cars) {
            // System.out.println(i);
            // }
            // System.out.println(Arrays.toString(cars));
            // ====
        }

        public void JavaMultiDimensionalArraysTest() {
            int[][] myNumbers = { { 1, 2, 3, 4 }, { 5, 6, 7 } };
            // ==== different ways to print out multi-dimensional array:
            // for (int i = 0; i < myNumbers.length; ++i) {
            //     for (int j = 0; j < myNumbers[i].length; ++j) {
            //         System.out.print(myNumbers[i][j] + ", ");
            //     }
            //     System.out.println();
            // }
            // for (int[] i : myNumbers) {
            //     for (int j : i) {
            //         System.out.print(j + ", ");
            //     }
            //     System.out.println();
            // }

            System.out.println(Arrays.deepToString(myNumbers));
        }
    }

    /**
     * Java List
     * Java List is an ordered collection. Java List is an
     * interface(https://www.w3schools.com/java/java_interface.asp) that extends
     * Collection interface. Java List provides control over the position where you
     * can insert an element. You can access elements by their index and also search
     * elements in the list.
     * 
     * Java List
     * Some of the important points about Java List are;
     * 
     * Java List interface is a member of the Java Collections Framework.
     * List allows you to add duplicate elements.
     * List allows you to have ‘null’ elements.
     * List interface got many default methods in Java 8, for example replaceAll,
     * sort and spliterator.
     * List indexes start from 0, just like arrays.
     * List supports Generics and we should use it whenever possible. Using Generics
     * with List will avoid ClassCastException at runtime.
     * https://www.digitalocean.com/community/tutorials/java-list
     */
    public interface JavaList extends JavaCollections {

    }

    public static class JavaAbstractList implements JavaList {
    }

    public static void JavaListTest() {
        // Creating an object of List class
        // Declaring an object of String type with
        // reference to ArrayList class
        // Type safe list

    }

    /**
     * Java ArrayList
     * need to import java.util.ArrayList;
     * The ArrayList class is a resizable array,
     * The difference between a built-in array and an ArrayList in Java, is that the
     * size of an array cannot be modified (if you want to add or remove elements
     * to/from an array, you have to create a new one). While elements can be added
     * and removed from an ArrayList whenever you want. The syntax is also slightly
     * different:
     */
    public class JavaArrayList extends JavaAbstractList {
        // Creating an ArrayList of String type
        // Type safe ArrayList
        ArrayList<String> carsArrayList = new ArrayList<>(Arrays.asList(cars)); // Create an ArrayList object
        AbstractList<String> carsAbstractList = new ArrayList<>(Arrays.asList(cars)); // Create an AbstractList object

        public void JavaArrayListTest() {
            // To access an element in the ArrayList, use the get() method and refer to the
            // index number:
            System.out.println("element at index 0: \n" + carsArrayList.get(0));
            System.out.println(carsAbstractList.get(0));

            // To change an element, use the set() method and refer to the index number:
            carsArrayList.set(0, "Opel");
            System.out.println(carsArrayList);

            // To add an element, use the add() method:
            carsArrayList.add("Lamborghini");
            System.out.println("After add Lambor:  \n" + carsArrayList);

            // To remove an item, use the remove() method:
            carsArrayList.remove(0);
            System.out.println("remove the element with index 0 \n" + carsArrayList);

            // To find out how many elements an ArrayList has, use the size() method:
            System.out.println("Array Size: \n" + carsArrayList.size());

            // To sort an ArrayList, use the sort() or Collection.sort() method
            carsArrayList.sort(Collections.reverseOrder());
            System.out.println("sort arrayList reversly: \n" + carsArrayList);
            carsArrayList.sort(Comparator.reverseOrder());
            System.out.println(carsArrayList);
            Collections.sort(carsArrayList);
            System.out.println("sort arrayList acc: \n" + carsArrayList);

            Collections.sort(carsArrayList);
            System.out.println(carsArrayList);

            // To convert an ArrayList to an array, use the toArray() method:
            Object[] carsArray = carsArrayList.toArray();
            System.out.println("To array: \n" + Arrays.toString(carsArray));

            // To remove all items, use the clear() method:
            carsArrayList.clear();
            System.out.println("clear the ArrayList: \n" + carsArrayList);

            // To check if an ArrayList is empty, use the isEmpty() method:
            System.out.println("Is Empty? : \n" + carsArrayList.isEmpty());

            // To copy one ArrayList into another, use the addAll() method:
            carsArrayList.addAll(Arrays.asList(cars));
            System.out.println(carsArrayList);

            // To insert an element at the first position, use the add(0, element) method:
            carsArrayList.add(0, "Opel");
            System.out.println("add Opel at the begining \n" + carsArrayList);

            // To insert an element at a specified position, use the add(index, element):
            carsArrayList.add(1, "Lamborghini");
            System.out.println("add Lamborghini at(before) the index of 1: \n" + carsArrayList);

            // To remove an element at a specified position, use the remove(index) method:
            carsArrayList.remove(3);
            System.out.println("remove the element at index of 3: \n" + carsArrayList);

            // To remove the first elements that have the same value as another element
            carsArrayList.remove("Opel");
            System.out.println("Remove all 'Opel' elements : " + carsArrayList);

            // To remove all elements that have the same value as another collection, use
            // the removeAll() method:
            carsArrayList.removeAll(Arrays.asList(cars));
            System.out.println(
                    "remove all elements that have the same value as cars[\"Volvo\", \"BMW\", \"Ford\", \"Mazda\" ] collection : "
                            + carsArrayList);

            // To remove all elements that have different values than another collection,
            // use the retainAll() method:
            carsArrayList.retainAll(Arrays.asList(cars));
            System.out.println(carsArrayList);

            // To find the index of an element, use the indexOf() method:
            System.out.println(carsArrayList.indexOf("Volvo"));

            // To find the last index of an element, use the lastIndexOf() method:
            System.out.println(carsArrayList.lastIndexOf("Volvo"));

            // To check if an ArrayList contains a certain element, use the contains()
            // method:
            System.out.println(carsArrayList.contains("Volvo"));

            // To check if two ArrayLists are equal, use the equals() method:
            System.out.println(carsArrayList.equals(Arrays.asList(cars)));

            // To create a sub-list, use the subList() method:
            System.out.println(carsArrayList.subList(0, 2));

        }
    }

    /**
     * java Vector
     * need to import java.util.Vector;
     * The Vector class implements a growable array of objects. Like an array, it
     * contains components that can be accessed using an integer index. However, the
     * size of a Vector can grow or shrink as needed to accommodate adding and
     * removing items after the Vector has been created.
     * The Java Vector class is very similar to ArrayList. The main difference is
     * that Vector is synchronized. If a thread-safe implementation is not needed,
     * it is recommended to use ArrayList in place of Vector.
     * The Java Vector class uses an array internally to store the elements. It
     * increases the array size by doubling it whenever it is full. It is similar to
     * the dynamic array implementation in C++.
     */
    public class javaVector extends JavaAbstractList {
        // Creating a Vector of String type
        // Type safe Vector
        Vector<String> carsVector = new Vector<>(Arrays.asList(cars)); // Create a Vector object
        AbstractList<String> carsAbstractList = new Vector<>(Arrays.asList(cars)); // Create an AbstractList object

        public void JavaVectorTest() {
            // To access an element in the Vector, use the get() method and refer to the
            // index number:
            System.out.println("element at index 0: \n" + carsVector.get(0));
            System.out.println(carsAbstractList.get(0));

            // To change an element, use the set() method and refer to the index number:
            carsVector.set(0, "Opel");
            System.out.println(carsVector);

            // To add an element, use the add() method:
            carsVector.add("Lamborghini");
            System.out.println("After add Lambor:  \n" + carsVector);

            // To remove an item, use the remove() method:
            carsVector.remove(0);
            System.out.println("remove the element with index 0 \n" + carsVector);

            // To find out how many elements an Vector has, use the size() method:
            System.out.println("Array Size: \n" + carsVector.size());

            // To sort an Vector, use the sort() or Collection.sort() method
            carsVector.sort(Collections.reverseOrder());
            System.out.println("sort Vector reversly: \n" + carsVector);
            carsVector.sort(Comparator.reverseOrder());
            System.out.println(carsVector);
            Collections.sort(carsVector);
            System.out.println("sort Vector acc: \n" + carsVector);

            Collections.sort(carsVector);
            System.out.println(carsVector);

            // To convert an Vector to an array, use the toArray() method:
            Object[] carsArray = carsVector.toArray();
            System.out.println("To array: \n" + Arrays.toString(carsArray));

            // To remove all items, use the clear() method:
            carsVector.clear();
            System.out.println("clear the Vector: \n" + carsVector);

            // To check if an Vector is empty, use the isEmpty() method:
            System.out.println("Is Empty? : \n" + carsVector.isEmpty());

            // To copy one Vector into another, use the
        }

    }

    /**
     * java Stack
     * need to import java.util.Stack;
     * The Stack class represents a last-in-first-out (LIFO) stack of objects.
     * The usual push and pop operations are provided, as well as a method to
     */
    public class JavaStack extends javaVector {
        // Creating an object of Stack class
        Stack<String> carsStack = new Stack<>();

        public void JavaStackTest() {
            // To add an element to the Stack, use the push() method:
            carsStack.push("Volvo");
            carsStack.push("BMW");
            carsStack.push("Ford");
            carsStack.push("Mazda");
            System.out.println("Stack: " + carsStack);

            // To remove an element from the Stack, use the pop() method:
            System.out.println("pop(): " + carsStack.pop());

            // To get the element at the top of the Stack, use the peek() method:
            System.out.println("peek(): " + carsStack.peek());

            // To get the size of the Stack, use the size() method:
            System.out.println("size(): " + carsStack.size());

            // To remove all elements from the Stack, use the clear() method:
            carsStack.clear();
            System.out.println("clear(): " + carsStack);

            // To check if the Stack is empty, use the empty() method:
            System.out.println("empty(): " + carsStack.empty());

            // To search for an element in the Stack, use the search() method:
            System.out.println("search(): " + carsStack.search("Volvo"));
        }

        /* The LinkedList class is almost identical to the ArrayList */
        public class myLinkedList extends JavaAbstractList {
            LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(2, 4, 3));
            LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(5, 6, 4));

        }

    }
}
