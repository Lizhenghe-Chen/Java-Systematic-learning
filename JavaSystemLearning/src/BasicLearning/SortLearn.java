package BasicLearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import MyTools.PrintTools;

interface SortType {
    public void SelectionSort(int[] arr);

    public void BubbleSort(int[] arr);

    public void InsertionSort(int[] arr);

    public void MergeSort(int[] arr, int start, int end);

    public void UseArraysSort(int[] arr);
}

/**
 * 【11大排序的原理讲解和Python源码剖析】
 * https://www.bilibili.com/video/BV1Zs4y1X7mN/?share_source=copy_web&vd_source=2cc9b009651a2e77962d97335570dde7
 * 跟着B站大佬重新学排序算法，到分治排序的时候已经自闭了，但是会坚持下去的。。
 * 部分代码AI生成，但是逻辑尽量贴合视频中的思路
 */
public class SortLearn {
    final static int[] arr = { 22, 10, 3, 8, 9, 1, 2, 5, 4, 7, 6, 0, 10, 22, 48, 56, 88, 97, 79, 66, 13, 52, 100 };

    public static void main(String[] args) {
        long globalStartTime = System.nanoTime();
        int[] tempTestArray = Arrays.copyOf(arr, arr.length);
        // set the tempTestArray to the original array
        PrintTools.println(Arrays.toString(arr));
        SortAlgorithums sort = new SortAlgorithums();
        // // ----------------------------------------
        // sort.BubbleSort(tempTestArray);
        // PrintTools.println(Arrays.toString(tempTestArray));
        // PrintTools.PrintExecutionTime(globalStartTime);

        // tempTestArray = Arrays.copyOf(arr, arr.length);
        // sort.BubbleSort(tempTestArray);
        // PrintTools.println(Arrays.toString(tempTestArray));
        // PrintTools.PrintExecutionTime(globalStartTime);

        // tempTestArray = Arrays.copyOf(arr, arr.length);
        // sort.InsertionSort(tempTestArray);
        // PrintTools.println(Arrays.toString(tempTestArray));
        // PrintTools.PrintExecutionTime(globalStartTime);

        tempTestArray = Arrays.copyOf(arr, arr.length);
        sort.MergeSort(tempTestArray, 0, tempTestArray.length - 1);
        PrintTools.println(Arrays.toString(tempTestArray));
        PrintTools.PrintExecutionTime(globalStartTime);
        // ----------------------------------------
    }
}

class SortAlgorithums implements SortType {
    /**
     * Bubble Sort, given an array, compare the former element with the latter one,
     * if the former element is bigger than the latter one, swap them.
     * 冒泡排序的核心思想是 每次遍历都把最大的元素放到最后面
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * 
     * @param arr the array to be sorted
     * @return the sorted array
     */
    @Override
    public void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {// the last element is sorted
            // start from the first element, then iterate to the last-1-i element, last-1 is
            // because 'arr[j + 1]', -i is because the last i elements are sorted
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {// if the former element is bigger than the latter one, swap them
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                // System.out.println(Arrays.toString(arr));
            }
        }
    }

    /**
     * Selection Sort, given an array, set a minIndex, then iterate the array to
     * find the min value, swap the min value with each iterate's first element.
     * 选择排序的核心思想是 每次遍历找到最小的元素，然后与当前遍历开始时的那个元素交换位置
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * 
     * @param arr the array to be sorted
     * @return the sorted array
     */
    @Override
    public void SelectionSort(int[] arr) {
        // start from the first element, then iterate to the last-1 element
        int minIndex = 0;
        int temp;
        for (int start = 0; start < arr.length - 1; start++) {
            // start from the next element, then iterate to the last element
            for (int i = start + 1; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;// record the index of the min value
                }
            }
            if (minIndex != start) {// this judgement can avoid the unnecessary swap
                // swap the min value with the current element
                temp = arr[start];
                arr[start] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

    }

    /**
     * Insertion Sort, given an array, set a temp to record the current element,
     * then iterate the array to find the right position to insert the current
     * element.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    @Override
    public void InsertionSort(int[] arr) {
        // start from the second element, then iterate to the last element
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];// record the value of the current element
            int j = i - 1;// the index of the former element
            /*
             * while (j >= 0) {// iterate to the first element
             * if (arr[j] > temp) {// if the former element is bigger than the current
             * element
             * arr[j + 1] = arr[j];// move the former element to the right
             * j--;// move the index to the left
             * } else {
             * break;// if the former element is smaller than the current element, break the
             * loop
             * }
             * }
             */
            // iterate to the first element, and the former element is bigger than the
            // current element
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];// move the former element to the right
                j--;// move the index to the left
            }
            arr[j + 1] = temp;// insert the current element to the right position
            // PrintTools.println(Arrays.toString(arr));
        }
    }

    public void MergeSort(int[] arr, int start, int end) {
        if (start >= end) {// if the array has only one element, return
            return;
        }
        int mid = (start + end) / 2;// the middle index
        MergeSort(arr, start, mid);// sort the left part
        MergeSort(arr, mid + 1, end);// sort the right part
        Merge(arr, start, mid, end);// merge the left and right part

    }

    private void Merge(int[] arr, int start, int mid, int end) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int l = start;
        int r = mid + 1;
        while (l <= mid && r <= end) {
            if (arr[l] < arr[r]) {
                // append the smaller one to the temp array
                // temp[i + j - start - mid - 1] = arr[i];//in python, temp.append(arr[i])
                temp.add(arr[l]);
                l++;
            } else {
                temp.add(arr[r]);
                r++;
            }
        }
        // append the rest of the left part, in python, temp.extend(arr[l:mid + 1])
        while (l <= mid) {
            temp.add(arr[l]);
            l++;
        }
        // append the rest of the right part
        while (r <= end) {
            temp.add(arr[r]);
            r++;
        }
        // copy the temp array to the original array
        for (int i = start; i <= end; i++) {
            arr[i] = temp.get(i - start);
        }
        // PrintTools.println(temp.toString());
    }

    @Override
    public void UseArraysSort(int[] arr) {
        // Arrays.sort(arr, 0, arr.length); // sort the whole array, or specify the
        // range
        // Arrays.sort(arr);// sort the whole array

        // convert int[] to Integer[]
        Integer[] arrInteger = new Integer[arr.length];
        Arrays.sort(arrInteger, Collections.reverseOrder());
    }
}
