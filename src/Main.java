import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String[] guests = new String[10];

    public static void main(String[] args) {

        insertTestNames();

        do {
            displayGuests();
            displayMenu();

            int option = getOption();

            if (option == 1) {
                addGuest();

            } else if (option == 2) {
                removeGuest();

            } else if (option == 3) {
                System.out.println("Exiting...");
                break;
            }
        } while (true);

    }


    static void displayGuests() {
        System.out.println("\n______________________________\n - Guests - ");
        boolean isEmpty = true;
        for (int i = 0; i < guests.length; i++) {

            if (guests[i] != null) {
                System.out.println((i + 1) + ". " + (guests[i]));
                isEmpty = false;
            }

        }
        if (isEmpty) {
            System.out.println("Guest list is empty");
        }
    }

    static void displayMenu() {
        System.out.println("______________________________\n- Menu -");
        System.out.println("1 - Add Guest");
        System.out.println("2 - Remove Guest");
        System.out.println("3 - Exit");
        System.out.print("Option: ");
    }

    static int getOption() {
        int option = scanner.nextInt();
        return option;
    }

    static void addGuest() {

        for (int i = 0; i < guests.length; i++) {
            if (guests[i] == null) {
                System.out.print("Name: ");
                guests[i] = scanner.next();

                break;
            }

        }

    }

    static void removeGuest() {
        System.out.print("Guest number: ");
        int guestNumber = scanner.nextInt();
        int flag = 0;
        for (int i = 0; i < guests.length; i++) {
            if ( guests[i] == guests[guestNumber-1]) {
                guests[i] = null;
                flag = 1;

            }
            //Code to move up all the elements when an element in the middle has been deleted
            if (flag == 1 && i != 9){
                guests[i] = guests[i+1];
            }
            if (flag == 1 && i == 9){
                guests[i] = null;
            }


        }
    }

    static void insertTestNames() {
        guests[0] = "Jacob";
        guests[1] = "Edward";
        guests[2] = "Rose";
        guests[3] = "Molly";
        guests[4] = "Christopher";
       /* guests[5] = "Alan";
        guests[6] = "Lucero";
        guests[7] = "Isabel";
        guests[8] = "Misael";
        guests[9] = "Noe";*/

    }
}