package by.itstep;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Launcher {


    public static void main(String[] args) {
        String x = " a ";
        x = x.trim();
        System.out.println(x);


    }

    public static void main1(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 5, 6, 7, 8);
        List<Integer> b = Arrays.asList(9, 10, 11, 12);
        Collections.copy(a, b);
        System.out.println(a);


    }


    public static void main111(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        Integer b[] = {6, 7, 8, 9, 10};

        //array -> list
        List<Integer> aList = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            aList.add(a[i]);

        List<Integer> bList = Arrays.asList(b);

        List<Integer> cList = new ArrayList<>(aList);
        cList.addAll(bList);

        List<Integer> dList = new ArrayList<>(aList.size() + bList.size());
        Collections.copy(dList, aList);
        dList.addAll(bList);


    }

    public static void commonElements(List<Integer> aList, List<Integer> bList) {
        aList.retainAll(bList);
        System.out.println(aList);
    }


    public static void allElements(List<Integer> aList, List<Integer> bList) {
        aList.addAll(bList);
        System.out.println(aList);
    }

}
























