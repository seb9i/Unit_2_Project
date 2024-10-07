import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create Scanner class and ask for input
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, enter your first coordinates");
        String coordinate1 = scan.nextLine();
        // Grab second coordinates
        System.out.println("Please enter your second coordinate");
        String coordinate2 = scan.nextLine();
        // Create linear equation instance using the 2 coordinates
        LinearEquation li = new LinearEquation(coordinate1, coordinate2);
        System.out.println(li);
        // Ask for third coordinate and return solution
        System.out.println("Please enter the third coordinate");
        int solved = scan.nextInt();

        li.addX(solved);
        System.out.println("Solved Coordinate: "+ li.solveCoordinate());

    }
}