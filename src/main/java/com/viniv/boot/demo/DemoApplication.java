package com.viniv.boot.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

       final Set s = new HashSet(Arrays.asList("first", "sec"));
       Set s1 = new HashSet();

        System.out.printf("id= %08.2f%n", 423.147);

       s.add("hello");

       s.remove("first");

        System.out.println(s);


        int[] intArray = {3, 1, -2, 2};
        int smallNo = smallestPositiveNumber(intArray);
        log.info("Smallest Positive Number : {} ", smallNo);
        int[] A = {3, 8, 9, 7, 6};
        int K = 5;

        int[] arrayRot = cyclicRotationOfArray(A, K);
        log.info("Cyclic Rotation  : {} ", Arrays.toString(arrayRot));

        String str = "abc";
        printArrayList(getPermutation(str));

    }

    private static int[] cyclicRotationOfArray(int[] A, int K) {

        if (K == A.length) {
            return A;
        }
        LinkedList<Integer> ll = Arrays.stream(A).boxed().collect(Collectors.toCollection(LinkedList::new));

        while (K > 0) {
            ll.addFirst(ll.getLast());
            ll.removeLast();
            K--;
        }

        return ll.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int smallestPositiveNumber(int[] intArray) {
        if (intArray.length == 0) {
            return -99;
        }
        Arrays.sort(intArray);

        if (intArray[0] >= 2) {
            return 1;
        }
        if (intArray[intArray.length - 1] <= 0) {
            return 1;
        }
        int smallestPositiveMissing = 1;
        for (int j : intArray) {
            if (j == smallestPositiveMissing) {
                smallestPositiveMissing++;
            }
        }
        return smallestPositiveMissing;
    }

    public static ArrayList<String> getPermutation(String str) {

        // If string is empty
        if (str.isEmpty()) {
            // Return an empty arraylist
            ArrayList<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }

        // Take first character of str
        char ch = str.charAt(0);

        // Take sub-string starting from the
        // second character
        String subStr = str.substring(1);

        // Recursive call
        ArrayList<String> prevResult = getPermutation(subStr);

        // Store the generated permutations
        // into the resultant arraylist
        ArrayList<String> Res = new ArrayList<>();

        for (String val : prevResult) {
            for (int i = 0; i <= val.length(); i++) {
                Res.add(val.substring(0, i) + ch + val.substring(i));
            }
        }

        // Return the resultant arraylist
        return Res;
    }

    static void printArrayList(ArrayList<String> arrL) {
        arrL.remove("");
        for (String s : arrL) System.out.print(s + " ");
    }


}
