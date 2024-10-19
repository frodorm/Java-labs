import java.util.Scanner;
import java.util.Arrays;


public class Main {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        boolean start = true;
        while(start){
            System.out.println("Введите номер задачи или 0 чтобы закончить");
            int num = in.nextInt();
            in.nextLine();
            switch (num){
                case 1:
                    System.out.println("Введите строку");
                    String word = in.nextLine();
                    String answer = task1(word);
                    System.out.println(answer);
                    break;
                case 2:
                    System.out.println("Введите размер для первого массива");
                    int size = in.nextInt();
                    int[] a = new int[size];
                    System.out.println("Введите числа для первого массива");
                    for(int i = 0; i < size; ++i){
                        a[i] = in.nextInt();
                    }
                    System.out.println("Введите размер для второго массива");
                    size = in.nextInt();
                    int[] b = new int[size];
                    System.out.println("Введите числа для второго массива");
                    for(int i = 0; i < size; ++i){
                        b[i] = in.nextInt();
                    }

                    Arrays.sort(a);
                    Arrays.sort(b);

                    int[] mergeMas = task2(a, b);
                    System.out.println(Arrays.toString(mergeMas));
                    break;

                case 3:
                    System.out.println("Введите размер для массива");
                    size = in.nextInt();
                    int[] s = new int[size];
                    System.out.println("Введите числа для массива");
                    for(int i = 0; i < size; ++i){
                        s[i] = in.nextInt();
                    }
                    System.out.println(task3(s));
                    break;
                case 4:
                    System.out.println("Введите количество строк и столбцов для двумероного массива n x s:");
                    int n1 = in.nextInt();
                    in.nextLine();
                    int n2 = in.nextInt();
                    int[][] mat = new int[n1][n2];
                    for(int i = 0; i < n1; ++i)
                    {
                        for(int j = 0; j < n2; ++j)
                        {
                            mat[i][j] = i;
                        }
                    }

                    int[][] matrix = task4(mat);
                    for(int i = 0; i < mat.length; ++i)
                    {
                        System.out.println(Arrays.toString(mat[i]));
                    }
                    for(int i = 0; i < matrix.length; ++i)
                    {
                        System.out.println(Arrays.toString(matrix[i]));
                    }
                    break;
                case 5:
                    System.out.println("введите размер массива");
                    size = in.nextInt();
                    int[] mas = new int[size];
                    System.out.println("Введите элементы массива");
                    for(int i = 0; i < size; ++i)
                    {
                        mas[i] = in.nextInt();
                    }
                    System.out.println("Введите target");
                    int target = in.nextInt();
                    int[] res = task5(mas, target);
                    System.out.println(Arrays.toString(res));
                    break;
                case 6:
                    System.out.println("Введите количество строк и столбцов для двумероного массива n x s: (заполняется он по принципу [i][j] = i + j)");
                    n1 = in.nextInt();
                    in.nextLine();
                    n2 = in.nextInt();
                    int[][] matr = new int[n1][n2];
                    for(int i = 0; i < n1; ++i)
                    {
                        for(int j = 0; j < n2; ++j)
                        {
                            matr[i][j] = i + j;
                        }
                    }
                    System.out.println(task6(matr));
                    break;
                case 7:
                    System.out.println("Введите количество строк и столбцов для двумероного массива n x s: (заполняется он по принципу [i][j] = i + j)");
                    n1 = in.nextInt();
                    in.nextLine();
                    n2 = in.nextInt();
                    int[][] matri = new int[n1][n2];
                    for(int i = 0; i < n1; ++i)
                    {
                        for(int j = 0; j < n2; ++j)
                        {
                            matri[i][j] = i + j;
                        }
                    }
                    System.out.println(Arrays.toString(task7(matri)));
                    break;
                case 8:
                    System.out.println("Введите количество строк и столбцов для двумероного массива n x s:");
                    n1 = in.nextInt();
                    in.nextLine();
                    n2 = in.nextInt();
                    int[][] ma = new int[n1][n2];
                    for(int i = 0; i < n1; ++i)
                    {
                        for(int j = 0; j < n2; ++j)
                        {
                            ma[i][j] = i;
                        }
                    }

                    int[][] mass = task8(ma);
                    for(int i = 0; i < ma.length; ++i)
                    {
                        System.out.println(Arrays.toString(ma[i]));
                    }
                    for(int i = 0; i < mass.length; ++i)
                    {
                        System.out.println(Arrays.toString(mass[i]));
                    }
                    break;
                case 0:
                    start = false;
                    break;
            }
        }

    }

    public static String task1(String word){
        int[] rep = new int[128];
        Arrays.fill(rep, -1);
        int current = 0;
        int maxL = 0;
        String maxS = "";

        for(int i = 0; i < word.length(); ++i)
        {
            char currentC = word.charAt(i);
            if(rep[currentC] >= current)
            {
                current = rep[currentC] + 1;
            }
            rep[currentC] = i;
            if(i - current  + 1 > maxL)
            {
                maxL = i - current + 1;
                maxS = word.substring(current, i + 1);

            }
        }

        return maxS;
    }

    public static int[] task2(int[] a, int[] b){
        int[] mergeMas = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int l = 0;
        while (i < a.length && j < b.length)
        {
            if (a[i] <= b[j])
            {
                mergeMas[l++] = a[i++];
            }
            else
            {
                mergeMas[l++] = b[j++];
            }
        }
        while (i < a.length)
        {
            mergeMas[l++] = a[i++];
        }
        while (j < b.length)
        {
            mergeMas[l++] = b[j++];
        }
        return mergeMas;
    }

    public static int task3(int[] s){
        int curSum = s[0];
        int maxSum = s[0];
        for (int i = 1; i < s.length; ++i)
        {
            curSum = Math.max(s[i], curSum + s[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public static int[][] task4(int[][] matrix) {
        int n1 = matrix.length;
        int n2 = matrix[0].length;
        int[][] rotated = new int[n2][n1];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                rotated[j][n1 - 1 - i] = matrix[i][j];
            }
        }

        return rotated;
    }

    public static int[] task5(int[] a, int tar) {
        int[] res = new int[2];
        int n = a.length;
        for(int i = 0; i < n - 1; ++i)
        {
            for(int j = i + 1; j < n; ++j)
            {
                if(a[i] + a[j] == tar)
                {
                    res[0] = a[i];
                    res[1] = a[j];
                    return res;
                }
            }
        }
        return null;
    }

    public static int task6(int[][] mas) {
        int s = mas.length;
        int n = mas[0].length;
        int sum = 0;
        for(int i = 0; i < s; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                sum += mas[i][j];
            }
        }
        return sum;
    }

    public static int[] task7(int[][] mas){
        int s = mas.length;
        int n = mas[0].length;
        int[] maxes = new int[s];
        for (int i = 0; i < s; i++)
        {
            maxes[i] = mas[i][0];
            for (int j = 0; j < n; j++)
            {
                if (mas[i][j] > maxes[i])
                {
                    maxes[i] = mas[i][j];
                }
            }
        }
        return maxes;

    }

    public static int[][] task8(int[][] mas) {
        int s = mas.length;
        int n = mas[0].length;
        int[][] rotMas = new int[n][s];
        for (int i = 0; i < s; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                rotMas[n - j - 1][i] = mas[i][j];
            }
        }

        return rotMas;
    }
}
