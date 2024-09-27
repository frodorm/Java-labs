import java.util.Scanner;

public class fiveTask {

    private static final Scanner in = new Scanner(System.in);
    int num;

    fiveTask(int num)
    {
        this.num = num;
    }

    public void check()
    {
        int first = num % 10;
        int second = num / 10 % 10;
        int third = num / 100;

        if((first + second + third) % 2 == 0 && (first*second*third) % 2 == 0)
        {
            System.out.println("Число " + num + " является дважды четеным");
        }
        else
        {
            System.out.println("Число " + num + " не является дважды четеным");
        }
    }
}
