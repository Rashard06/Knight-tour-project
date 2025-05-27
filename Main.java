import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter starting row (0-7): ");
        int startRow = scanner.nextInt();
        System.out.print("Enter starting column (0-7): ");
        int startCol = scanner.nextInt();

        Tour tour = new Tour();
        if (tour.knightsTour(startRow, startCol)) {
            System.out.println("Knight's Tour solution:");
            tour.printBoard();
        } else {
            System.out.println("No solution found from that starting point.");
        }
    }
}
