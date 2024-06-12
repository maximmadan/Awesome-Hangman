import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static String selectRandomWord() {
        String words[] = new String[] {
                "pear", "plum", "lion", "tent", "desk", "dino", "deer",
                "joy", "bond", "hill", "pond", "bike", "ship",
                "glow", "bird", "cake", "yard", "book", "band", "star",
                "lava", "beam", "moth", "roo", "lime", "gold", "void",
                "lens", "herb", "sleuth", "case", "fair", "corn", "beam",
                "trip", "chop", "gator", "insect", "dawn", "ice", "bird",
                "trip", "almond", "blimp", "tree", "fall", "harp", "star",
                "flora"
        };
        Random r = new Random();
        int randomIndex = r.nextInt(words.length);
        String randomWord = words[randomIndex];
        return randomWord;
    }
    public static String hideTheWord(String word) {
        return "*".repeat(word.length());
    }
    public static void startGame() {
        /* TODO: next time need to add gamelogic */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean runningGame = true;
        String randomWord = selectRandomWord();
        hideTheWord(randomWord);

        while(runningGame) {
            System.out.println("Welcome to Hangman! ");
            System.out.println("Start game 1:");
            System.out.println("Exit game 2:");
            System.out.println("Please enter your choide: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    startGame(sc);
                    break;
                case 2:
                    System.out.println("Leave the game");
                    runningGame = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}