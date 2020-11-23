import java.util.Scanner;

public class MainApp {
    void printMainMenu() {
        System.out.println("Select Your Application");
        System.out.println("-----------------------");
        System.out.println("");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
        System.out.println("");
        System.out.print("> ");
    }

    public static void main(String[] args) {
        int flag = 0;
        int userInput;
        MainApp app = new MainApp();
        TaskApp taskApp = new TaskApp();
        ContactApp contactApp = new ContactApp();
        Scanner input = new Scanner(System.in);
        while (flag != 1) {
            app.printMainMenu();
            userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    taskApp.main();
                    break;
                case 2:
                    contactApp.main();
                    break;
                case 3:
                    flag = 1;
                    break;
                default:
                    System.out.println("Invalid selection!");
                    break;
            }
        }
        input.close();
    }
}
