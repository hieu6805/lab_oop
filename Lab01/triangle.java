import java.util.Scanner;
public class triangle {
    public static int i, j;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        for (i = 1; i <= rows; i++) {
            for (j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= 2*i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.exit(0);
    }
}