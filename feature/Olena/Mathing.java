import java.util.ArrayList;

public class Mathing {

    ArrayList <ArrayList<Double>> c;
    public Mathing (){
    }

    public void scalarMatrix(ArrayList <ArrayList<Double>> a, Double l){
        c = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < a.size(); i++){
            ArrayList <Double> arrayList = new ArrayList<Double>();
            for (int j = 0; j < a.get(0).size(); j ++){
                Double k = a.get(i).get(j)*l;
                arrayList.add(k);
            }
            c.add(arrayList);
        }
        System.out.println("Результат множення на скаляр: ");
        Matrix_decide matrix_decide = new Matrix_decide(c);
        matrix_decide.outing();
    }

    public void add (ArrayList <ArrayList<Double>> a, ArrayList <ArrayList<Double>> b){
        c = new ArrayList<ArrayList<Double>>();
        if (matrix(a, b)){
            for (int i = 0; i < a.size(); i++){
                ArrayList <Double> arrayList = new ArrayList<Double>();
                for (int j = 0; j < a.get(0).size(); j ++){
                    Double k = a.get(i).get(j) + b.get(i).get(j);
                    arrayList.add(k);
                }
                c.add(arrayList);
            }
            System.out.println("Результат додавання: ");
            Matrix_decide matrix_decide = new Matrix_decide(c);
            matrix_decide.outing();
        }
        else System.out.println("Матриці різного розміру");

    }

    public boolean matrix (ArrayList <ArrayList<Double>> a, ArrayList <ArrayList<Double>> b){
        if (a.size() != b.size()){
            return false;
        }
        if (a.get(0).size() != b.get(0).size()){
            return false;
        }
        return true;
    }

    public boolean square(ArrayList <ArrayList<Double>> a) {
        if (a.size() != a.get(0).size()) {
            return false;
        }
        return true;
    }

    public void multiple(ArrayList <ArrayList<Double>> a, ArrayList <ArrayList<Double>> b){
        c = new ArrayList<ArrayList<Double>>();
        if (a.get(0).size()!=b.size()){
            System.out.println("Розмір матриць не допускає процедуру множення");
            return;
        }
        for (int i = 0; i < a.size(); i ++){
            ArrayList <Double> arrayList = new ArrayList<Double>();
            for (int j = 0; j < b.get(0).size(); j ++){
                Double l = 0.0;
                for (int k = 0; k < b.size(); k++){
                    l = l + a.get(i).get(k)*b.get(k).get(j);
                }
                arrayList.add(l);
            }
            c.add(arrayList);
        }
        Matrix_decide matrix_decide = new Matrix_decide(c);
        matrix_decide.outing();
    }

    public void transpon(ArrayList <ArrayList<Double>> a){
        c = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < a.get(0).size(); i ++){
            ArrayList <Double> arrayList = new ArrayList<Double>();
            for (int j = 0; j < a.size(); j ++){
                arrayList.add(a.get(j).get(i));
            }
            c.add(arrayList);
        }
        Matrix_decide matrix_decide = new Matrix_decide(c);
        matrix_decide.outing();
    }

    public Double det_mat(ArrayList <ArrayList<Double>> a, int n) {
        Double[][] M = new Double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = a.get(i).get(j);
            }
        }
        if (n == 1) {
            return M[0][0];
        }
        if (n == 2) {
            Double s = (M[0][0] * M[1][1]) - (M[1][0] * M[0][1]);
            return s;
        } else {
            Double res = 0.0;
            boolean bo = false;

            Double[][] A = new Double[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = M[i][j];
                }
            }

            Double[][] B = new Double[n - 1][n - 1];

            for (int d = 0; d < n; d++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (k != d) {
                            if (j != 0) {
                                if (!bo) {
                                    B[j - 1][k] = A[j][k];
                                } else B[j - 1][k - 1] = A[j][k];
                            }
                        } else bo = true;
                    }
                    bo = false;
                }
                ArrayList<ArrayList<Double>> bb = new ArrayList<ArrayList<Double>>();
                for (int i = 0; i < n - 1; i++) {
                    ArrayList<Double> dd = new ArrayList<Double>();
                    for (int j = 0; j < n - 1; j++) {
                        dd.add(B[i][j]);
                    }
                    bb.add(dd);
                }
                if (((d + 2) % 2) == 0) {

                    res += A[0][d] * det_mat(bb, n - 1);
                } else res -= A[0][d] * det_mat(bb, n - 1);

            }
            return res;
        }
    }

    public void matrix(ArrayList <ArrayList<Double>> a, int n){
        Double[][] A = new Double[n][n];
        Double[][] B = new Double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = a.get(i).get(j);
            }
        }
        for (int k = 0; k < n; k ++){
            for (int i = 0; i < n; i ++){
                for (int j = 0; j < n; j ++){
                    if ((i==k)&&(j==k)){
                        B[i][j]=1/A[i][j];
                    }
                    if ((i==k)&&(j!=k)){
                        B[i][j]=-A[i][j]/A[k][k];
                    }
                    if ((i!=k)&&(j==k)){
                        B[i][j]=A[i][k]/A[k][k];
                    }
                    if ((i!=k)&&(j!=k)){
                        B[i][j]=A[i][j]-A[k][j]*A[i][k]/A[k][k];
                    }
                }
            }
            for (int i = 0; i < n; i ++){
                for (int j = 0; j < n; j ++){
                    A[i][j] = B[i][j];
                }
            }
        }
        for (int l = 0; l < n; l ++){
            for (int j = 0; j < n; j ++){
                System.out.print(A[l][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void matrixG(ArrayList <ArrayList<Double>> a, int n){
        Double [][] E = new Double[n][n];
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j ++){
                if (i == j){
                    E[i][j] = 1.0;
                }
                else {
                    E [i][j] = 0.0;
                }
            }
        }
        Double[][] A = new Double[n][n];
        Double[][] Res = new Double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = a.get(i).get(j);
            }
        }

        for (int i = 0; i < n; i ++){
            Double c = A[i][i];
            for (int j = n-1; j >= 0; j --){
                A[i][j] = A[i][j]/c;
                E[i][j] = E[i][j]/c;
                for (int k = i + 1; k < n; k ++){
                    E[k][j] = E[k][j] - A[k][i]*E[i][j];
               /* }
                for (int k = i + 1; k < n; k ++){*/
                    A[k][j] = A[k][j] - A[k][i]*A[i][j];
                }
            }
            System.out.println(i);
            for (int l = 0; l < n; l ++){
                for (int j = 0; j < n; j ++){
                    System.out.print(A[l][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
            for (int l = 0; l < n; l ++){
                for (int j = 0; j < n; j ++){
                    System.out.print(E[l][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }

        }
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j ++){
                System.out.print(A[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j ++){
                System.out.print(E[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        for (int j = 0; j < n; j ++){
            Res[n - 1][j] = E[n - 1][j];
        }

        for (int i = n - 2; i >=0; i --){
            for (int l = 0; l < n; l ++){
                Double S = 0.0;
                for (int j = i + 1; j < n; j ++){
                    S = S + Res[j][l]*A[i][j];
                }
                Res [i][l] = E[i][l] - S;
            }
        }

        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n; j ++){
                System.out.print(Res[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

}
