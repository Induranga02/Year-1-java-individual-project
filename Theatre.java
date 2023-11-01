import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.File;
import java.io.FileWriter;

public class Theatre {
    static int[] row1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}; //create arrays outside methods, so they can access at anywhere
    static int[] row2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    static int[] row3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    static  ArrayList<Object> ticket_info = new ArrayList<>();

    static Person person1 = new Person("name", "surname", "email");
    static Ticket ticket1 = new Ticket(01, 04, 20);

    public static void main(String[] args) {
        System.out.println("Welcome to New Theatre cinema");


        for (int i = 0; i < row1.length; i++) {
            row1[i] = 0;
        }
        for (int i = 0; i < row2.length; i++) {
            row2[i] = 0;
        }
        for (int i = 0; i < row3.length; i++) {
            row3[i] = 0;
        }
        // main menu
        System.out.println("------------------------------------------------");
        System.out.println("Please select an option:");
        System.out.println("1) Buy a ticket ");
        System.out.println("2) Print seating area");
        System.out.println("3) cancel ticket");
        System.out.println("4) List available seats");
        System.out.println("5) Save to file");
        System.out.println("6) Load from file");
        System.out.println("7) Print ticket information and total price");
        System.out.println("8) Sort tickets by price");
        System.out.println("0) Quit");
        System.out.println("------------------------------------------------");
        Scanner option = new Scanner(System.in);
        System.out.print("Enter option:");
        int x = option.nextInt();

        switch (x) {

            case 0:
                quit();
                System.exit(0);

            case 1:
                buy_ticket();
                break;

            case 2:
                print_seating_area();
                break;

            case 3:
                cancel_ticket();
                break;

            case 4:
                show_available();
                break;

            case 5:
                save();
                break;

            case 6:
                load();
                break;

            case 7:
                show_ticket_info();
                break;

            case 8:
                main_menu();
                break;

            default:
                System.out.println("Invalid choice.Please try again.");
                main_menu();


        }
    }

    static void main_menu() {                                                       //creating a method for  main menu 
        System.out.println("------------------------------------------------");
        System.out.println("Please select an option:");
        System.out.println("1) Buy a ticket ");
        System.out.println("2) Print seating area");
        System.out.println("3) cancel ticket");
        System.out.println("4) List available seats");
        System.out.println("5) Save to file");
        System.out.println("6) Load from file");
        System.out.println("7) Print ticket information and total price");
        System.out.println("8) Sort tickets by price");
        System.out.println("0) Quit");
        System.out.println("------------------------------------------------");
        Scanner option = new Scanner(System.in);
        System.out.print("Enter option:");
        int x = option.nextInt();

            if (x == 1) {
                buy_ticket();
            } else if (x == 2) {
                print_seating_area();
            } else if (x == 3) {
                cancel_ticket();
            } else if (x == 4) {
                show_available();

            } else if (x == 5) {
                save();
            } else if (x == 6) {
                load();
            } else if (x == 7) {
                show_ticket_info();
            } else if (x == 8) {
                main_menu();
            } else if (x == 0) {
                quit();
                System.exit(0);
            }
            else{
                System.out.println("invalid choice.Please try again");
                main_menu();
            }
    }


    static void buy_ticket() {                       //option 1- buy tickets
        while (true) {
            System.out.println();
            System.out.println("* Buy a Ticket *");

            Scanner input = new Scanner(System.in);
            System.out.print("Enter row number:");
            int row_num = input.nextInt();

            System.out.print("Enter seat number:");
            int seat_num = input.nextInt();

            Scanner input_2 = new Scanner(System.in);
            System.out.print("Enter name:");
            String name = input_2.nextLine();

            System.out.print("Enter surname:");
            String surname = input_2.nextLine();

            System.out.print("Enter email:");
            String email = input_2.nextLine();

            double price = 0;

            if (row_num == 1) {
                price = 100.00;
            } else if (row_num == 2) {
                price = 200.00;
            } else if (row_num == 3) {
                price = 250.00;
            }

            ticket_info.add("name:" + name);                //adding elements to arraylist
            ticket_info.add("surname:" + surname);
            ticket_info.add("email:" + email);
            ticket_info.add("row:" + row_num);
            ticket_info.add("seat:" + seat_num);
            ticket_info.add("price:");
            ticket_info.add( price);


            if (row_num > 0 && row_num < 4) {           //checking validation of user inputs and booking seats
                if (row_num == 1 && seat_num <= 12) {
                    if (row1[seat_num - 1] == 0) {
                        System.out.println("Dear " + name + ", The seat you have searched is available and it has booked for you");
                        row1[seat_num - 1] = 1;

                    } else {
                        System.out.println("The seat has already booked");
                    }
                } else if (row_num == 2 && seat_num <= 16) {
                    if (row2[seat_num - 1] == 0) {
                        System.out.println("Dear " + name + ", The seat you have searched is available and it has booked for you");
                        row2[seat_num - 1] = 1;

                    } else {
                        System.out.println("The seat has already booked");
                    }
                } else if (row_num == 3 && seat_num <= 20) {
                    if (row3[seat_num - 1] == 0) {
                        System.out.println("Dear " + name + ", The seat you have searched is available and it has booked for you");
                        row3[seat_num - 1] = 1;


                    } else {
                        System.out.println("The seat has already booked");
                    }
                } else
                    System.out.println("Invalid seat number");
                    System.out.println();

            } else {
                System.out.println("Invalid row number or seat number. Please try again");
                System.out.println();
            }

            main_menu();

        }

    }


    static void print_seating_area() {              //option 2- print seating area
        while (true) {

            System.out.println("* Seating area *");
            System.out.println("------------------------------------------------");
            System.out.println("    *************");
            System.out.println("    *   STAGE   *");
            System.out.println("    *************");
            System.out.print(" ");
            System.out.print(" ");
            System.out.print(" ");
            System.out.print(" ");
            for (int i = 0; i < 6; i++) {
                if (row1[i] == 0) {
                    System.out.print("o");
                } else if (row1[i] == 1) {
                    System.out.print("x");
                }
            }
            System.out.print(" ");
            for (int i = 6; i < 12; i++) {
                if (row1[i] == 0) {
                    System.out.print("o");
                } else if (row1[i] == 1) {
                    System.out.print("x");
                }
            }
            System.out.println();
            System.out.print(" ");
            System.out.print(" ");
            for (int i = 0; i < 8; i++) {
                if (row2[i] == 0) {
                    System.out.print("o");
                } else if (row2[i] == 1) {
                    System.out.print("x");
                }
            }
            System.out.print(" ");
            for (int i = 8; i < 16; i++) {
                if (row2[i] == 0) {
                    System.out.print("o");
                } else if (row2[i] == 1) {
                    System.out.print("x");
                }
            }
            System.out.println();

            for (int i = 0; i < 10; i++) {
                if (row3[i] == 0) {
                    System.out.print("o");
                } else if (row3[i] == 1) {
                    System.out.print("x");
                }
            }
            System.out.print(" ");
            for (int i = 10; i < 20; i++) {
                if (row3[i] == 0) {
                    System.out.print("o");
                } else if (row3[i] == 1) {
                    System.out.print("x");
                }
            }
            System.out.println();
            main_menu();
        }
    }

    static void cancel_ticket() {            //option 3-cancel ticket
        while (true) {
            System.out.println();
            System.out.println("* Cancel Ticket *");
            Scanner cancel_row = new Scanner(System.in);
            System.out.print("Enter row number:");
            int row_num = cancel_row.nextInt();

            Scanner cancel_seat = new Scanner(System.in);
            System.out.print("Enter seat number:");
            int seat_num = cancel_seat.nextInt();

            if (row_num > 0 && row_num < 4) {          //checking validation of user inputs and cancelling seats

                if (row_num == 1 && seat_num <= 12) {
                    if (row1[seat_num - 1] == 1) {
                    System.out.println(" cancelling  booking for row " + row_num + " seat " + seat_num);
                    row1[seat_num - 1] = 0;
                    } else {
                    System.out.println("Seat have not booked yet");
                    }
                }
                else if (row_num == 2 && seat_num <= 16) {
                        if (row2[seat_num - 1] == 1) {
                            System.out.println(" cancelling  booking for row " + row_num + " seat " + seat_num);
                            row2[seat_num - 1] = 0;
                        } else {
                            System.out.println("Seat have not booked yet");
                        }
                    }
                else if (row_num == 3 && seat_num <= 20) {
                        if (row3[seat_num - 1] == 1) {
                            System.out.println("cancelling  booking for row " + row_num + " seat " + seat_num);
                            row3[seat_num - 1] = 0;
                        } else {
                            System.out.println("Seat have not booked yet");
                        }
                }
            else{
                    System.out.println("Invalid seat number.Please try again");
                    System.out.println();
                }
            }
            else {
                System.out.println("Invalid row number or seat number. Please try again");
                System.out.println();
                }

            main_menu();
        }
    }

    static void show_available() {          //option 4- show available tickets
        System.out.println("* Available seats list *");

        System.out.print("seats available in row1: ");
        for (int i = 0; i < row1.length; i++) {

            if (row1[i] == 0) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();

        System.out.print("seats available in row2: ");
        for (int i = 0; i < row2.length; i++) {

            if (row2[i] == 0) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();

        System.out.print("seats available in row3: ");
        for (int i = 0; i < row3.length; i++) {

            if (row3[i] == 0) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();

        main_menu();
    }

    static void save() {            //option 5-save to a file
        int j = 0;
        int k = 0;
        int l = 0;

        for (int i = 0; i < row1.length; i++) {

            if (row1[i] == 0) {
                j = j + 1;
            }
        }

        for (int i = 0; i < row2.length; i++) {

            if (row2[i] == 0) {
                k = k + 1;
            }
        }

        for (int i = 0; i < row3.length; i++) {

            if (row3[i] == 0) {
                l = l + 1;
            }
        }

        System.out.println("printing row information");    //writing in file
        try {
            FileWriter info = new FileWriter("information.txt");
            info.write(
                    "\n" + "* row 1 information *\n" +
                            "------------------------------------------------\n" +
                            "total number of seats=12\n\n" +
                            "seats available in row1: ('0' shows seat is available and '1' shows seat is booked )\n \n"
                            + Arrays.toString(row1) + "\n\n" +
                            "number of seats available is " + j + "\n\n" +

                            "* row 2 information *\n" +
                            "------------------------------------------------\n" +
                            "total number of seats=16\n\n" +
                            "seats available in row2: ('0' shows seat is available and '1' shows seat is booked )\n \n"
                            + Arrays.toString(row2) + "\n\n" +
                            "number of seats available is " + k + "\n\n" +

                            "* row 3 information *\n" +
                            "------------------------------------------------\n" +
                            "total number of seats=20\n\n" +
                            "seats available in row3: ('0' shows seat is available and '1' shows seat is booked )\n \n"
                            + Arrays.toString(row3) + "\n\n" +
                            "number of seats available is " + l + "\n\n");
            info.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        main_menu();
    }

    static void load() {                        //option 6-load from file
        File file = new File("information.txt");
        try {
            Scanner load = new Scanner(file);
            while (load.hasNextLine()) {
                System.out.println(load.nextLine());
            }
            load.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        main_menu();
    }

    static void show_ticket_info() {        //option 7-show ticket information

        for (int i = 0; i < ticket_info.size(); i++) {
            if (i % 7 == 0 && i != ticket_info.size() - 1) {
                System.out.println();
                System.out.println("Ticket information");
                System.out.println();
            }
            System.out.print(ticket_info.get(i));
            System.out.println();
        }
        double sum = 0;
        for (int i = 6; i < ticket_info.size(); i += 7) {
            Object obj = ticket_info.get(i);
            if (obj instanceof Number) {
                double num = ((Number) obj).doubleValue();
                sum += num;
            }
        }
        System.out.println();
        System.out.println("total price for tickets:"+" Rs."+sum);

        main_menu();
    }
    static void quit(){         //quit
        System.out.println("Thanks for using New theater cinmea seat booking program.\nHave a nice day.");
    }
}










