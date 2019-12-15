package dao.util.card;

import java.util.Random;

public class CardPassGenerator {

    public static int getRandomCvv() {
        Random rand = new Random();
        return (rand.nextInt(900) + 100);
    }

    public static int getRandomPin() {
        Random rand = new Random();
        return (rand.nextInt(9000) + 1000);
    }
}
