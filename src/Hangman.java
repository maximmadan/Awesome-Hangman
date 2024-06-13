import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static String selectRandomWord() {
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
        return words[randomIndex];
    }
    private static String hideTheWord(String word) {
        return "*".repeat(word.length());
    }
    private static void printHangman(int attemptsLeft) {
        switch (attemptsLeft) {
            case 5:
                System.out.println("  -----  ");
                System.out.println("  |   |  ");
                System.out.println("      |  ");
                System.out.println("      |  ");
                System.out.println("      |  ");
                System.out.println("      |  ");
                System.out.println("=========");
                break;
            case 4:
                System.out.println("  -----  ");
                System.out.println("  |   |  ");
                System.out.println("  o   |  ");
                System.out.println("      |  ");
                System.out.println("      |  ");
                System.out.println("      |  ");
                System.out.println("=========");
                break;
            case 3:
                System.out.println("  -----  ");
                System.out.println("  |   |  ");
                System.out.println("  o   |  ");
                System.out.println("  |   |  ");
                System.out.println("      |  ");
                System.out.println("      |  ");
                System.out.println("=========");
                break;
            case 2:
                System.out.println("  -----  ");
                System.out.println("  |   |  ");
                System.out.println("  o   |  ");
                System.out.println(" /|   |  ");
                System.out.println("      |  ");
                System.out.println("      |  ");
                System.out.println("=========");
                break;
            case 1:
                System.out.println("  -----  ");
                System.out.println("  |   |  ");
                System.out.println("  o   |  ");
                System.out.println(" /|\\  |  ");
                System.out.println("      |  ");
                System.out.println("      |  ");
                System.out.println("=========");
                break;
            case 0:
                System.out.println("  -----  ");
                System.out.println("  |   |  ");
                System.out.println("  o   |  ");
                System.out.println(" /|\\  |  ");
                System.out.println(" / \\  |  ");
                System.out.println("      |  ");
                System.out.println("=========");
                break;
            default:
                System.out.println("=========");
        }
    }
    public static void startGame(Scanner sc) {
        String randomWord = selectRandomWord();
        String hiddenWord = hideTheWord(randomWord);
        int attemptsLeft = 6;
        StringBuilder guessedWord = new StringBuilder(hiddenWord);


        while (attemptsLeft > 0  && guessedWord.toString().contains("*")) {
            System.out.println("Current word: " + guessedWord);
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.println("Enter your word: ");
            char guess = sc.next().charAt(0);
            boolean correctGuess = false;

            for(int i = 0; i < randomWord.length(); i++) {
                if(guess == randomWord.charAt(i)) {
                    guessedWord.setCharAt(i, guess);
                    correctGuess = true;
                }
            }

            if(!correctGuess) {
                attemptsLeft--;
                System.out.println("Wrong guess, try again");
                printHangman(attemptsLeft);
            }
        }

        if (attemptsLeft > 0) {
            System.out.println("Congratulations! You guessed the word: " + randomWord);
        } else {
            System.out.println("Game over. The word was: " + randomWord);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean runningGame = true;

        while(runningGame) {
            System.out.println("Welcome to Hangman! ");
            System.out.println("Start game 1:");
            System.out.println("Exit game 2:");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    startGame(sc);
                    break;
                case 2:
                    System.out.println("Leaving the game");
                    runningGame = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }
        sc.close();
    }
}