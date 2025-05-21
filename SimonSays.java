import java.util.*;
public class SimonSays {
    private static final String[] COLORS = {"Red", "Green", "Blue", "Yellow"};
    private static List<String> sequence = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    public static void main(String[] args) {
        System.out.println("Welcome to Simon Says!");
        System.out.println("Repeat the color sequence. Type exactly as shown (case-sensitive).");
        boolean playing = true;
        int level = 1;
        while (playing) {
            System.out.println("\nLevel " + level);
            addColorToSequence();
            showSequence();

            if (!getUserInput()) {
                System.out.println("Wrong sequence. Game Over!");
                System.out.println("You reached Level " + level);
                playing = false;
            } else {
                System.out.println(" Correct!");
                level++;
            }
        }

        System.out.println("Thanks for playing!");
    }

    private static void addColorToSequence() {
        String nextColor = COLORS[random.nextInt(COLORS.length)];
        sequence.add(nextColor);
    }

    private static void showSequence() {
        System.out.print("Simon says: ");
        for (String color : sequence) {
            System.out.print(color + " ");
        }
        System.out.println();
        try {
            Thread.sleep(1000); // simulate time delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static boolean getUserInput() {
        System.out.println("Now, repeat the sequence (space-separated):");
        String input = scanner.nextLine();
        String[] userSequence = input.trim().split("\\s+");

        if (userSequence.length != sequence.size()) {
            return false;
        }

        for (int i = 0; i < sequence.size(); i++) {
            if (!sequence.get(i).equals(userSequence[i])) {
                return false;
            }
        }

        return true;
    }
}
