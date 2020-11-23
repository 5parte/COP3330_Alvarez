import java.util.Scanner;

public class TaskApp {

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
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
        System.out.println("");
        System.out.print("> ");
    }

    void printTaskItems(TaskList list) {
        if (list == null) {
            System.out.println("list is empty...");
            return;
        }

        TaskItem temp;
        for (int i = 0; i < list.list.size(); i++) {
            temp = list.getItem(i);
            if (temp.completed == true)
                System.out.print("*** ");
            System.out.println(i + ") [" + temp.dueDate + "] " + temp.title + ": " + temp.description);
        }
        System.out.println("");
    }

    TaskList getUserItem(TaskList list) {
        Scanner input = new Scanner(System.in);
        System.out.print("Task Title: ");
        String title = input.nextLine();
        System.out.print("Task description: ");
        String description = input.nextLine();
        System.out.print("Task due date (YYYY-MM-DD): ");
        String dueDate = input.nextLine();
        System.out.println("");
        TaskItem item = new TaskItem(title, description,dueDate, false);
        list.addItem(item);

        return list;
    }

    TaskList editAnItem(TaskList list) {
        printTaskItems(list);
        Scanner input = new Scanner(System.in);
        System.out.print("Which task will you edit? ");
        int index = input.nextInt();
        System.out.println("");
        if (index >= list.list.size())
            return list;

        System.out.print("Enter a new title for task " + index + " ");
        input.nextLine();
        String title = input.nextLine();
        list.getItem(index).setTitle(title);
        System.out.print("Enter a new description for task " + index + " ");
        String description = input.nextLine();
        list.getItem(index).setDescription(description);
        System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + index + " ");
        String dueDate = input.nextLine();
        list.getItem(index).setDueDate(dueDate);
        return list;
    }

    TaskList removeAnItem(TaskList list) {
        printTaskItems(list);
        Scanner input = new Scanner(System.in);
        System.out.print("Which task will you remove? ");
        int index = input.nextInt();
        list.removeItem(index);
        return list;
    }

    TaskList markCompleted(TaskList list) {
        printTaskItems(list);
        Scanner input = new Scanner(System.in);
        System.out.print("Which task will you mark as completed? ");
        int index = input.nextInt();
        list.getItem(index).setCompleted(true);
        return list;
    }

    TaskList unmarkCompleted(TaskList list) {
        printTaskItems(list);
        Scanner input = new Scanner(System.in);
        System.out.print("Which task will you unmark as completed? ");
        int index = input.nextInt();
        list.getItem(index).setCompleted(false);
        return list;
    }

    TaskList saveList(TaskList list) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename to save as: ");
        String fileName = input.nextLine();
        list.saveList(fileName, list);
        System.out.println("");
        return list;
    }

    TaskList examineList(TaskList list) {
        int userInput;
        int flag = 0;
        Scanner input = new Scanner(System.in);
        while (flag != 1) {
            printOperationMenu();
            userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    printTaskItems(list);
                    break;
                case 2:
                    try {
                        list = getUserItem(list);
                    }
                    catch (Exception ex) {
                        System.out.println("WARNING: invalid input, task not created");
                    }
                    break;
                case 3:
                    try {
                        list = editAnItem(list);
                    }
                    catch (Exception ex) {
                        System.out.println("WARNING: invalid input, task not edited");
                    }
                    break;
                case 4:
                    try {
                        list = removeAnItem(list);
                    }
                    catch (Exception ex) {
                        System.out.println("WARNING: invalid index, task not removed");
                    }

                    break;
                case 5:
                    try {
                        list = markCompleted(list);
                    }
                    catch (Exception ex) {
                        System.out.println("WARNING: invalid index, task not marked completed");
                    }
                    break;
                case 6:
                    try {
                        list = unmarkCompleted(list);
                    }
                    catch (Exception ex) {
                        System.out.println("WARNING: invalid index, task not unmarked completed");
                    }
                    break;
                case 7:
                    list = saveList(list);
                    break;
                case 8:
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
        TaskApp app = new TaskApp();
        Scanner input = new Scanner(System.in);
        while (flag != 1) {
            app.printMainMenu();
            userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    TaskList list = new TaskList();
                    app.examineList(list);
                    break;
                case 2:
                    TaskList loadingList = new TaskList();
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