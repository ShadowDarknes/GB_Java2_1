package HomeWork_L2_1;

import java.util.Random;

public class Human {
    private static int a, b;


    public static void jumpUp(){
        Random rnd = new Random();
        a = 1 + rnd.nextInt(3);
        System.out.println("Могу прыгнуть на " + a + " Метров");
        Side s1 = new Side();
        s1.Height(a);

    }
    public static void run(){
        Random rnd = new Random();
        b = 1 + rnd.nextInt(100);
        System.out.println("Могу пробежать " + b + " Км");
        Running_track r1 = new Running_track();
        r1.Long(b);

    }


    public static void main(String[] args) {
        jumpUp();
        run();
        Side s1 = new Side();
        s1.Height(a);
        Running_track r1 = new Running_track();
        r1.Long(b);

    }
}
