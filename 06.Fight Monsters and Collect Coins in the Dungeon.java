import java.util.Arrays;
import java.util.Scanner;

public class Zada4i5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int coins = 0;
        int countRooms = 0;
        String[] rooms = scanner.nextLine().split("\\|");

        for (int i = 0; i < rooms.length; i++) {
            countRooms++;
            String[] insideRoom = rooms[i].split(" ");
            String monster = insideRoom[0];
            int num = Integer.parseInt(insideRoom[1]);
            int previousHealth = 0;

            if ("potion".equals(monster)) {
                previousHealth = health;
                health += num;

                if (health > 100) {
                    health = 100;
                    System.out.printf("You healed for %d hp.%n", 100 - previousHealth);
                } else {
                    System.out.printf("You healed for %d hp.%n", num);
                }

                System.out.printf("Current health: %d hp.%n", health);

            } else if ("chest".equals(monster)) {
                coins += num;
                System.out.printf("You found %d coins.%n", num);

            } else {
                health -= num;
                if (health > 0) {
                    System.out.printf("You slayed %s.%n", monster);
                } else {
                    System.out.printf("You died! Killed by %s.%n", monster);
                    System.out.printf("Best room: %d%n", i+1);
                    break;
                }
            }
        }

        if (countRooms == rooms.length && health > 0) {
            System.out.printf("You've made it!%nCoins: %d%nHealth: %d%n", coins, health);
        }
    }
}