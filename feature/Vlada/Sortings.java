package sample;



public class Sortings {
    public static Integer bubble(Integer [] array, Integer n){
        Integer x, c = 0;
        for (int i = 0; i < n - 1; i ++){
            for ( int j = 0; j < n - i - 1; j ++){
                if (array[j] > array[j + 1]){
                    c ++;
                    x = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = x;
                }
            }
        }
        return c;
    }

    public static Integer coctail(Integer [] array, Integer n){
        Integer x, c = 0;
        Boolean swap = false;
        for (int j = 0; j < n - 1; j ++){
            swap = false;
            for (int i = 0; i < n - 1 - j; i ++){
                if (array[i] > array[i + 1]){
                    c ++;
                    x = array[i];
                    array[i] = array[i+1];
                    array[i + 1]= x;
                    swap = true;
                }
            }
            for (int i = n - j - 2; i >= j; i --){
                if (array[i] > array[i + 1]){
                    c ++;
                    x = array[i];
                    array[i] = array[i+1];
                    array[i + 1]= x;
                    swap = true;
                }
            }
            if (!swap){
                return c;
            }
        }
        return c;
    }

    public static Integer extrem(Integer [] array, Integer n){
        Integer max, x, k = n, c = 0;
        for (int j = 0; j < n; j++){
            max = array[0];
            x = 0;
            for (int i = 0; i < k; i++){
                if (max < array[i]){
                    max = array[i];
                    x = i;
                }
            }
            array[x] = array[k - 1];
            array[k - 1] = max;
            c ++;
            k = k - 1;
        }
        return c;
    }

    public static Integer insert(Integer [] array, Integer n){
        Integer m, c = 0;
        for (int i = 0; i < n; i ++){
            for (int j = i; (j >0)&&(array[j - 1] > array[j]); j --){
                c ++;
                m = array[j];
                array[j] = array[j - 1];
                array[j - 1] = m;
            }
        }
        return c;
    }
    public static Integer quick(Integer [] array, Integer n){
        Integer c = 0;

        return c;
    }
}
