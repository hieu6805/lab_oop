import java.util.Scanner;
public class DaysInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month, year;
        while (true) {
            System.out.print("Enter the month: ");
            String monthStr = sc.nextLine();
            System.out.print("Enter the year: ");
            year= sc.nextInt();
            sc.nextLine();
            month = getMonth(monthStr);
            if (month != -1 && year>=0) {
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            } 
        }
        int days = getDaysInMonth(month, year);
        System.out.println("Number of days in the month: " + days);
    }
    public static int getMonth(String monthStr){
        String[][] validMonthNames = {
            {"January", "Jan.", "Jan", "1"},
            {"February", "Feb.", "Feb", "2"},
            {"March", "Mar.", "Mar", "3"},
            {"April", "Apr.", "Apr", "4"},
            {"May", "May", "May", "5"},
            {"June", "June", "Jun", "6"},
            {"July", "July", "Jul", "7"},
            {"August", "Aug.", "Aug", "8"},
            {"September", "Sept.", "Sep", "9"},
            {"October", "Oct.", "Oct", "10"},
            {"November", "Nov.", "Nov", "11"},
            {"December", "Dec.", "Dec", "12"}
    };

    for (int i = 0; i < validMonthNames.length; i++) {
        for (String name : validMonthNames[i]) {
            if (monthStr.equalsIgnoreCase(name)) {
                return i + 1;
            }
        }
    }
    return -1;
}
public static int getDaysInMonth(int month, int year) {
    int days = 0;
    switch (month) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            days = 31;
            break;
        case 4: case 6: case 9: case 11:
            days = 30;
            break;
        case 2:
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                days = 29;
            } else {
                days = 28;
            }
            break;
    }
    return days;
}
}
