package Searching;

import java.util.Scanner;
import java.util.Arrays;

public class Search {

    public static int linearSearch(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target){
        int s = 0;
        int e = arr.length - 1;

        while (s <= e){
            int mid = s + (e-s)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) e = mid -1;
            else s = mid + 1;
        }

        return -1;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int[] arr = {2, 8, -1, 12, 3, 11, 10, 6, 4, 9, 5, 7};
        System.out.println("Enter the target");
        int target = sc.nextInt();

        System.out.println("Linear Search");
        int index_ls = linearSearch(arr, target);
        if (index_ls == -1) {
            System.out.println("Element not found using Linear search !");
        } else {
            System.out.println("Element found using Linear search at index : " + index_ls);
        }

        System.out.println("Binary Search");
        int[] arr2 = {10, 20, 30, 40, 50, 60, 70};
        int index_bs = binarySearch(arr2, 50);
        if (index_bs == -1) {
            System.out.println("Element not found using Binary search !");
        } else {
            System.out.println("Element found using Binary search at index : " + index_bs);
        }

        sc.close();


    }
}
