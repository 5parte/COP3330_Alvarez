import java.util.Scanner;

public class ContactApp {

    void printMainMenu() {
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        System.out.println("");
        System.out.print("> ");
    }

    void printOperationMenu() {
        System.out.println("List Operation Menu");
        System.out.println("---------");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
        System.out.println("");
        System.out.print("> ");
    }

    void printContactItems(ContactList list) {
        if (list == null) {
            System.out.println("list is empty...");
            return;
        }

        ContactItem temp;
        for (int i = 0; i < list.list.size(); i++) {
            temp = list.getItem(i);
            System.out.println(i + ") Name: " + temp.firstName + " " + temp.lastName);
            System.out.println("Phone: " + temp.phoneNumber);
            System.out.println("Email: " + temp.email);
        }
        System.out.println("");
    }

    ContactList getUserItem(ContactList list) {
        Scanner input = new Scanner(System.in);
        System.out.print("First Name: ");
        String firstName = input.nextLine();
        System.out.print("Last Name: ");
        String lastName = input.nextLine();
        System.out.print("Phone number (xxx-xxx-xxxx): ");
        String phoneNumber = input.nextLine();
        System.out.print("Email address (x@y.z): ");
        String email = input.nextLine();
        System.out.println("");
        ContactItem item = new ContactItem(firstName, lastName, phoneNumber, email);
        list.addItem(item);

        return list;
    }

    ContactList editAnItem(ContactList list) {
        printContactItems(list);
        Scanner input = new Scanner(System.in);
        System.out.print("Which contact will you edit? ");
        int index = input.nextInt();
        System.out.println("");
        if (index >= list.list.size())
            return list;

        System.out.print("Enter a first name for contact " + index + " ");
        input.nextLine();
        String firstName = input.nextLine();
        list.getItem(index).setFirstName(firstName);
        System.out.print("Enter a new last name for contact " + index + " ");
        String lastName = input.nextLine();
        list.getItem(index).setLastName(lastName);
        System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + index + " ");
        String phoneNumber = input.nextLine();
        list.getItem(index).setPhoneNumber(phoneNumber);
        System.out.print("Enter a new email (x@y.z) for contact: " + index + " ");
        String email = input.nextLine();
        list.getItem(index).setEmail(email);
        return list;
    }

    ContactList removeAnItem(ContactList list) {
        printContactItems(list);
        Scanner input = new Scanner(System.in);
        System.out.print("Which contact will you remove? ");
        int index = input.nextInt();
        list.removeItem(index);
        return list;
    }

    ContactList saveList(ContactList list) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename to save as: ");
        String fileName = input.nextLine();
        list.saveList(fileName, list);
        System.out.println("");
        return list;
    }

    ContactList examineList(ContactList list) {
        int userInput;
        int flag = 0;
        Scanner input = new Scanner(System.in);
        while (flag != 1) {
            printOperationMenu();
            userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    printContactItems(list);
                    break;
                case 2:
                    try {
                        list = getUserItem(list);
                    }
                    catch (Exception ex) {
                        System.out.println("WARNING: invalid input, contact not created");
                    }
                    break;
                case 3:
                    try {
                        list = editAnItem(list);
                    }
                    catch (Exception ex) {
                        System.out.println("WARNING: invalid input, contact not edited");
                    }
                    break;
                case 4:
                    try {
                        list = removeAnItem(list);
                    }
                    catch (Exception ex) {
                        System.out.println("WARNING: invalid index, contact not removed");
                    }
                    break;
                case 5:
                    list = saveList(list);
                    break;
                case 6:
                    flag = 1;
                    break;
                default:
                    System.out.println("Invalid selection!");
                    break;
            }
        }
        return list;
    }

    public void main() {
        int flag = 0;
        int userInput;
        ContactApp app = new ContactApp();
        Scanner input = new Scanner(System.in);
        while (flag != 1) {
            app.printMainMenu();
            userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    ContactList list = new ContactList();
                    app.examineList(list);
                    break;
                case 2:
                    ContactList loadingList = new ContactList();
                    System.out.println("Enter the filename to load: ");
                    input.nextLine();
                    String fileName = input.nextLine();
                    loadingList = loadingList.loadList(fileName);
                    app.examineList(loadingList);
                    break;
                case 3:
                    flag = 1;
                    break;
                default:
                    System.out.println("Invalid selection!");
                    break;
            }
        }
    }
}