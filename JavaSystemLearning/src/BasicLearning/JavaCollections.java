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
    static long startTime = System.currentTimeMillis();

    public static void main(String[] args) {

        // JavaListTest();
        new JavaArrayList().JavaArrayListTest();
        System.out.println("Total Time: \n" + (System.currentTimeMillis() - startTime) + "ms");
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
        List<String> list = new ArrayList<String>(Arrays.asList(cars));
        Object result[] = list.toArray();
        // Printing the array
        for (Object object : result) {
            System.out.println(object);
        }
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

    /* The LinkedList class is almost identical to the ArrayList */
    public class myLinkedList extends JavaAbstractList {
        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(2, 4, 3));
        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(5, 6, 4));

      
    }

}
