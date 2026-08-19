import java.util.Scanner;

public class IsLeapYear {
    static void LeapYear(int year){
        if(year % 400 == 0){
            System.out.println(year + " is a Leap year");
        }
        else if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + " is a Leap year");
        }
        else {
            System.out.println(year + " is not a Leap year");
        }
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        int year = 0;
        do {
            System.out.print("Enter the year : ");
            year = sc.nextInt();
        }while (year < 0);
        LeapYear(year);
    }
}
