

import java.util.LinkedList;
import java.util.Scanner;

public class AtmInterface {

    static Scanner scanner = new Scanner(System.in);
    static int tryNo = 0;
    static {
        System.out.println("-*-*-*-*-*--*-*-*-*-Welcome to ATM-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("Insert your card");
    }

    public static void main(String[] args) {

        LinkedList<Clint> clintList = new LinkedList<>();
        Clint clint1 = new Clint("Khushi", 987654321, 28754, 1234);
        Clint clint2 = new Clint("Ramendra", 987456225, 200, 1478);
        Clint clint3 = new Clint("Sakshi", 987654474, 7841, 3654);
        Clint clint4 = new Clint("Aman", 654321474, 4785, 7896);
        Clint clint5 = new Clint("Jagdish", 987654321, 1236, 5874);

        clintList.offer(clint1);
        clintList.offer(clint2);
        clintList.offer(clint3);
        clintList.offer(clint4);
        clintList.offer(clint5);

        Clint clint = AtmInterface.checkPin(clintList);
        AtmInterface.choice(clint);

    }

    public static void choice(Clint clint) {

        System.out.println("# Press 1 to Check balance");
        System.out.println("# Press 2 to Withdraw");
        System.out.println("# Press 3 to Credit");
        System.out.println("# Press 4 to Exit");
        char choice = scanner.next().charAt(0);

        switch (choice) {
            case '1': {
                System.out.println(clint.chechBalance());
                AtmInterface.ThankYou();
            }
                break;
            case '2':
                AtmInterface.withdraw(clint);
                break;
            case '3':
                AtmInterface.credit(clint);
                break;
            case '4':
                AtmInterface.ThankYou();
                break;
            default: {
                System.out.println("Invalid entry try again");
                AtmInterface.choice(clint);
            }
                break;
        }
    }

    private static void ThankYou() {
        System.out.println(" Thank you for using our services ");

        System.out.println("Press [y] for new session ");
        System.out.println("Press [n] to exit");

        char choice = scanner.next().charAt(0);

        if (choice == 'y')
            AtmInterface.main(null);
    }

    private static void credit(Clint clint) {
        System.out.println("Enter amount to be credit:-");
        float ammount = scanner.nextFloat();

        float result = clint.credit(ammount);
        System.out.println("Account Balance = " + result);
        AtmInterface.ThankYou();

    }

    private static void withdraw(Clint clint) {
        System.out.println("Enter amount to be withdraw:-");
        float ammount = scanner.nextFloat();
        float result = clint.withdraw(ammount);

        if (result == -1) {
            System.out.println("Insufficient Balance = " + clint.chechBalance());
        } else
            System.out.println("Remaining Balance = " + result);
        AtmInterface.ThankYou();

    }

    public static Clint checkPin(LinkedList<Clint> clintList) {

        System.out.println("Enter ATM Pin:- ");
        int pin = scanner.nextInt();

        if (Integer.toString(pin).length() != 4 && tryNo <= 3) {
            System.out.println("Invalid Pin Try Again");
            tryNo++;
            AtmInterface.checkPin(clintList);
            return null;
        }
        for (Clint clint : clintList) {
            if (clint.getAtmPin() == pin) {
                System.out.println(clint.toString());
                return clint;
            }
        }
        return null;

    }
}
