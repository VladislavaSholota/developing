package sample;

import java.util.ArrayList;


public class TableSortings {
    public static ArrayList <ArrayList<Integer>> bubble(Integer [] array, Integer n){
        Integer x;
        ArrayList <ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList <Integer> arrayList = new ArrayList<>();
        for (int p = 0; p < n; p ++){
            arrayList.add(array[p]);
        }
        arrayLists.add(arrayList);
        Boolean swap = false;
        for (int j = 0; j < n - 1; j ++){
            swap = false;
            for (int i = 0; i < n - j - 1; i ++){
                if (array[i] > array[i + 1]){
                    x = array[i];
                    array[i] = array[i+1];
                    array[i + 1]= x;
                    swap = true;
                    arrayList = new ArrayList<>(n);
                    for (int p = 0; p < n; p ++){
                        arrayList.add(array[p]);
                    }
                    arrayLists.add(arrayList);
                }
            }
            for (int i = n - j - 2; i>= j; i --){
                if (array[i] > array[i + 1]){
                    x = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = x;
                    swap = true;

                    arrayList = new ArrayList<>(n);
                    for (int p = 0; p < n; p ++){
                        arrayList.add(array[p]);
                    }
                    arrayLists.add(arrayList);
                }
            }
            if (!swap){
                return arrayLists;
            }
        }
        return arrayLists;
    }
    public static ArrayList <ArrayList<Integer>> coctail(Integer [] array, Integer n){
        ArrayList <ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList <Integer> arrayList = new ArrayList<>();
        for (int p = 0; p < n; p ++){
            arrayList.add(array[p]);
        }
        arrayLists.add(arrayList);

        return arrayLists;
    }
    public static ArrayList <ArrayList<Integer>> extrem(Integer [] array, Integer n){
        Integer max, x, k = n;
        ArrayList <ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList <Integer> arrayList = new ArrayList<>();
        for (int p = 0; p < n; p ++){
            arrayList.add(array[p]);
        }
        arrayLists.add(arrayList);
        k = n;
        for (int j = 0; j < n; j ++){
            max = array[0];
            x = 0;
            for (int i = 0; i < k; i ++){
                if (max < array[i]){
                    max = array[i];
                    x = i;
                }
            }
            array[x] = array[k - 1];
            array[k - 1] = max;
            arrayList = new ArrayList<>();
            for (int p = 0; p < n; p ++){
                arrayList.add(array[p]);
            }
            arrayLists.add(arrayList);
            k = k - 1;
        }

        return arrayLists;
    }
    public static ArrayList <ArrayList<Integer>> insert(Integer [] array, Integer n){
        Integer c = 0, m ;
        ArrayList <ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList <Integer> arrayList = new ArrayList<>();
        for (int p = 0; p < n; p ++){
            arrayList.add(array[p]);
        }
        arrayLists.add(arrayList);
        for (int i = 0; i < n; i ++){
            for (int j = 1; (j > 0)&&(array[j - 1] > array[j]); j --){
                c ++;
                m = array[j];
                array[j] = array[j - 1];
                array[j - 1] = m;
                arrayList = new ArrayList<>(n);
                for (int p = 0; p < n; p ++){
                    arrayList.add(array[p]);

                }
                arrayLists.add(arrayList);
            }
        }
        System.out.println(c);
        return arrayLists;
    }
    public static ArrayList <ArrayList<Integer>> quick(Integer [] array, Integer n){
        ArrayList <ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList <Integer> arrayList = new ArrayList<>();
        for (int p = 0; p < n; p ++){
            arrayList.add(array[p]);
        }
        arrayLists.add(arrayList);

        return arrayLists;
    }
}
