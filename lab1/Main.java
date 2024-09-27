import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean start = true;
        while(start) {
            System.out.println("Введите задачу или 0 чтобы закончить");
            int num = in.nextInt();
            switch(num){
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 0:
                    start = false;
                    break;
            }
        }
    }

    public static void task1(){
        System.out.println("choose number");

        int n = in.nextInt();

        while(true)
        {
            if(n > 0)
            {
                break;
            }
            else
            {
                System.out.println("your number must be more than zero, try again");
                n = in.nextInt();
            }
        }

        int counter = 0;

        while(true) {

            if (n % 2 == 0)
            {
                n = n / 2;
                counter += 1;
            }

            else if(n == 1){
                System.out.println(counter);
                break;
            }

            else
            {
                n = 3 * n + 1;
                counter += 1;
            }
        }
    }

    public static void task2(){

        System.out.println("write how many numbers will be in sequence");

        int n = in.nextInt();

        while(true)
        {
            if(n > 0)
            {
                break;
            }
            else
            {
                System.out.println("your number must be more than zero, try again");
                n = in.nextInt();
            }
        }

        int sum = 0;

        System.out.println("write your sequence");

        for(int i = 0; i < n; ++i)
        {
            int number = in.nextInt();
            sum += Math.pow(-1, i) * number;
        }

        System.out.println(sum);
    }

    public static void task3(){
        System.out.println("write coordinates of treasure");

        int treasureX = in.nextInt();
        int treasureY = in.nextInt();
        int currentX = 0;
        int currentY = 0;
        boolean achievement = false;
        int counter = 0;

        while(true)
        {
            System.out.println("write direction or стоп");
            String dir = in.next();

            if(dir.equals("стоп"))
            {
                break;
            }

            System.out.println("write coordinate");
            int step = in.nextInt();

            switch (dir)
            {
                case "север":
                    currentY += step;
                    break;
                case "юг":
                    currentY -= step;
                    break;
                case "запад":
                    currentX -= step;
                    break;
                case "восток":
                    currentX += step;
                    break;
                default:
                    System.out.println("wrong line, stop program and try again");


            }

            if(!achievement)
            {
                ++counter;

                if (currentX == treasureX && currentY == treasureY)
                {
                    achievement = true;
                }
            }
        }


        System.out.println(counter);
    }

    public static void task4(){
        System.out.println("write number of roads");
        int roads = in.nextInt();

        int maxHeigth = 0;
        int bestRoad = 0;

        for(int i = 1; i <= roads; ++i)
        {
            int minHeight = 1000;
            System.out.println("write how many tunnels on " + i + "  road");
            int tunnels = in.nextInt();

            for(int j = 0; j < tunnels; ++j)
            {
                System.out.println("write hight of " + j + " tunnel");
                int height = in.nextInt();

                if (minHeight > height)
                {
                    minHeight = height;
                }
            }

            if(minHeight > maxHeigth)
            {
                maxHeigth = minHeight;
                bestRoad = i;
            }
        }

        System.out.println(bestRoad + " " + maxHeigth);
    }

    public static void task5(){
        System.out.println("write your number");
        int n = in.nextInt();

        fiveTask test = new fiveTask(n);
        test.check();
    }
}
