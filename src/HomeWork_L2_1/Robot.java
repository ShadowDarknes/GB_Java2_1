package HomeWork_L2_1;

import java.util.Random;

public class Robot {
    private static int a, b;
    static Random rnd = new Random();


    public static void jumpUp(){
        a = 1 + rnd.nextInt(10);
        System.out.println("Могу прыгнуть на " + a + " М.");
        Side s1 = new Side();
        s1.Height(a);

    }
    public static void run(){
        b = 1 + rnd.nextInt(1000);
        System.out.println("Могу пробежать " + b + " Км.");
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
