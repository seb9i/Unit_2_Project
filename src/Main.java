import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, enter your first coordinates");
        Scanner scan = new Scanner(System.in);
        String coordinate1 = scan.nextLine();
        String[] coord1List = coordinate1.substring(1, coordinate1.length() - 1).split(", ");
        System.out.println("second");
        String coordinate2 = scan.nextLine();
        LinearEquation li = new LinearEquation(coordinate1, coordinate2);
        System.out.println(li);
        System.out.println("Please enter the third coordinate");
        int solved = scan.nextInt();
        li.addX(solved);
                System.out.println("Solved Coordinate: "+ li.solveCoordinate());

    }
}