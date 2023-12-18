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

            } else if (option == 3){
                renameGuest();

            } else if (option == 4) {
                addGuestSpecificPosition();

            } else if(option == 5){
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
        System.out.println("3 - Rename Guest");
        System.out.println("4 - Add guest in position");
        System.out.println("5 - Exit");
        System.out.print("Option: ");
    }

    static int getOption() {
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }

    static void addGuest() {

        for (int i = 0; i < guests.length; i++) {
            if (guests[i] == null) {
                System.out.print("Name: ");
                guests[i] = scanner.nextLine();

                break;
            }

        }

    }

    static void removeGuest() {
        System.out.print("Guest number: ");
        int guestNumber = scanner.nextInt();
        int flag = 0;

        if(guestNumber > 0 && guestNumber < 10 && guests[guestNumber -1] != null){


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

        } else {
            System.out.println("Error. There is no guest with that number");
        }
    }

    static void insertTestNames() {
        guests[0] = "Jacob Hughes";
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

    static void renameGuest(){
        System.out.println("Guest number:");
        int guestNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        if(guestNumber > 0 && guestNumber < 10 && guests[guestNumber -1] != null) {
            System.out.println("New name: ");
            String newName = scanner.nextLine();


            guests[guestNumber - 1] = newName;
        } else {
            System.out.println("Error. There is no guest with that number");
        }

    }

    static void addGuestSpecificPosition(){

        System.out.println("Guest number:");
        int guestNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        if(guestNumber > 0 && guestNumber < 10 && guests[guestNumber -1] != null) {
            System.out.println("New name: ");
            String newName = scanner.nextLine();

            for (int i = guests.length -1; i > guestNumber -1 ; i--){
                guests[i] = guests[i-1];
            }
            guests[guestNumber - 1] = newName;
        } else {
            System.out.println("Error. There is no guest with that number");
        }

    }
}