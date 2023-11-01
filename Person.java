import java.util.Scanner;
import java.lang.*;
public class Person {
    String name;
    String surname;
    String email;
    static Person person1=new Person("null","null","null");
    public Person(String name,String surname,String email){
        this.name=name;
        this.surname=surname;
        this.email=email;
    }
    void name() {

        Scanner input = new Scanner(System.in);
        System.out.print("enter name:");
        String inputname_1 = input.nextLine();
        person1.name = inputname_1;

        System.out.print("enter surname:");
        String inputsurname_1 = input.nextLine();
        person1.surname = inputsurname_1;

        System.out.print("enter email:");
        String inputemail_1 = input.nextLine();
        person1.email = inputemail_1;
    }

    void outputs(){
        System.out.println("name is "+person1.name);
        System.out.println("surname is "+person1.surname);
        System.out.println("email is "+person1.email);
    }
    public static void main(String[] args) {
        Person person1=new Person("name","surname","email");
        person1.name();
        person1.outputs();

    }
}
