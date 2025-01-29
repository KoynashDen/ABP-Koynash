import java.util.Random;
import java.util.Scanner;
public class Lab_1 {
    public static void lab_1() {
        Lab_1 task = new Lab_1();
        task.task1();
        task.task2();
        task.task3();
        task.task4();
        task.task5();

    }
    public void task1(){
        System.out.println("Завдання 1");
        Scanner scanner = new Scanner(System.in);
        System.out.print("x1 = ");
        int x1 = scanner.nextInt();
        System.out.print("y1 = ");
        int y1 = scanner.nextInt();
        System.out.print("x2 = ");
        int x2 = scanner.nextInt();
        System.out.print("y2 = ");
        int y2 = scanner.nextInt();

        int x3 = (x1 + x2)/2;
        int y3 = (y1 + y2)/2;
        System.out.println("x3 = " + x3 + ", y3 = " + y3);


    }
    public void task2(){
        System.out.println("Завдання 2");
        Scanner scanner = new Scanner(System.in);
        System.out.print("x = ");
        int x = scanner.nextInt();
        System.out.print("y = ");
        int y = scanner.nextInt();
        System.out.print("z = ");
        int z = scanner.nextInt();

        if (x>y && x>z){
            if (y>z){
                System.out.println(x + "," + y + "," + z);
            }
            else{
                System.out.println(x + "," + z + "," + y);
            }
        }else if (x<y && x<z){
            if (y>z){
                System.out.println(y + "," + z + "," + x);
            }else{
                System.out.println(z + "," + y + "," + x);
            }
        }else if (x>y && x<z){
            if (y>z){
                System.out.println(z + "," + x + "," + y);
            }
            else{
                System.out.println(y + "," + x + "," + z);
            }
        }else {
            System.out.println(x + "," + y + "," + z);
        }
    }
    public void task3(){
        System.out.println("Завдання 3");
        Scanner scanner = new Scanner(System.in);
        System.out.print("x = ");
        int x = scanner.nextInt();
        System.out.print("y = ");
        int y = scanner.nextInt();
        for (int i = x; i <= y; i++){
            System.out.print(i+" ");
        }
        System.out.println("Кількість:" + (y-x+1));
    }
    public void task4(){
        System.out.println("Завдання 4");
        Scanner scanner = new Scanner(System.in);
        System.out.print("N = ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++){
            array[i] = random.nextInt(4);
        }
        int[] counts = new int[4];
        System.out.println("Масив:");
        for (int i = 0; i < n; i++){
            counts[array[i]]++;
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println("Кількість 0,1,2,3(відповідно): "+counts[0]+","+counts[1]+","+counts[2]+","+counts[3]);

    }
    public void task5(){
        System.out.println("Завдання 5");
        double tmpSquare = 0;
        int tmpTriangle = 0;
        for (int i = 1; i<=3; i++){
            System.out.println("Введіть координати " + i + " трикутника:");
            Scanner scanner = new Scanner(System.in);
            System.out.print("x1 = ");
            int x1 = scanner.nextInt();
            System.out.print("y1 = ");
            int y1 = scanner.nextInt();
            System.out.print("x2 = ");
            int x2 = scanner.nextInt();
            System.out.print("y2 = ");
            int y2 = scanner.nextInt();
            System.out.print("x3 = ");
            int x3 = scanner.nextInt();
            System.out.print("y3 = ");
            int y3 = scanner.nextInt();
            double area = square(x1, y1, x2, y2, x3, y3);
            if(tmpSquare<area){
                tmpSquare = area;
                tmpTriangle = i;
            }
        }
        System.out.println("Найбільша площа у " + tmpTriangle + " трикутника");


    }
    public double square(int x1,int y1,int x2,int y2,int x3,int y3){
        double result = Math.abs(x1*(y2-y3)+x2*(y3-y1) + x3*(y1-y2))/2;
        return result;
    }
}
