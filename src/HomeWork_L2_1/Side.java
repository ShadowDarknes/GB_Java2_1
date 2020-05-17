package HomeWork_L2_1;

import java.util.Random;

public class Side {
    Random rnd = new Random();
//    private static int c;

    public void Height(int b) {
        int c;
        c = 1 + rnd.nextInt(b + b / 2);
        if (b >= c) {
            System.out.println("Смог перепрыгнуть " + c + " М.");
        } else {
            System.out.println("Не смог перепрыгнуть " + c + " М.");
        }
    }
}
