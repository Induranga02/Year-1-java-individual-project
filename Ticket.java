import java.util.Scanner;

public class Ticket {
    int row;
    int seat;
    double price;

    static Person person1=new Person("name","surname","email");     //objects
    static  Ticket ticket1=new Ticket(00,00,00);

    public Ticket(int row,int seat,double price){
        this.row=row;
        this.seat=seat;
        this.price=price;
    }

    void name(){
        Scanner input=new Scanner(System.in);
        System.out.print("enter name:");
        String inputname_2=input.nextLine();
        person1.name=inputname_2;

        System.out.print("enter surname:");
        String inputsurname_2=input.nextLine();
        person1.surname=inputsurname_2;

        System.out.print("enter email:");
        String inputemail_2=input.nextLine();
        person1.email=inputemail_2;

    }

    void ticket(){

        Scanner input=new Scanner(System.in);

        System.out.print("enter row:");
        int inputrow=input.nextInt();
        ticket1.row=inputrow;

        System.out.print("enter seat:");
        int inputseat=input.nextInt();
        ticket1.seat=inputseat;

        System.out.print("enter price:");
        double inputprice=input.nextDouble();
        System.out.println();
        ticket1.price=inputprice;

    }


    void print(){
        System.out.println("name is "+person1.name);
        System.out.println("surname is "+person1.surname);
        System.out.println("email is "+person1.email);
        System.out.println("row number is "+ticket1.row);
        System.out.println("seat number is "+ticket1.seat);
        System.out.println("price is "+ticket1.price);
        System.out.println();

    }

    public static void main(String[] args) {

        ticket1.name();
        ticket1.ticket();
        ticket1.print();
    }

}
