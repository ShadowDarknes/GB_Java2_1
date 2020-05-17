package HomeWork_L2_1;

import java.util.Random;

public class Running_track {
    Random rnd = new Random();
//    private static int c;

    public void Long(int b) {
        int c;
        c = 1 + rnd.nextInt(b + b / 2);
        if (b >= c) {
            System.out.println("Смог пробежать " + c + " Км");
        } else {
            System.out.println("Не смог пробежать " + c + " Км");
        }
    }
}
