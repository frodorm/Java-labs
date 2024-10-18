import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

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
}
