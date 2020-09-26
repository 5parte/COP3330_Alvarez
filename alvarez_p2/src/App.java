import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static boolean moreInput (){
        Scanner input = new Scanner(System.in);
        int i;
        String more;

        for (i = 0; i < 1; i++) {

            System.out.print("Add an input (Y or N)?\n");

            more = input.next();
            input.nextLine();

            if (more.equals("Y")) {
                return true;
            }

            if (more.equals("N")) {
                return false;
            } else {
                System.out.print("Inappropriate input >:(\n");
                i = i - 1;
            }
        }
        return false;
    }

    public static double getUserHeight (){
        double height = 0;
        Scanner input = new Scanner(System.in);
        int i;

        for (i = 0; i < 1; i++) {

            System.out.print("Enter your height: \n");

            if (input.hasNextDouble()) {
                height = input.nextDouble();
                input.nextLine();
            }

            if (height <= 0) {
                System.out.print("Error: Input must be a positive value.\n");
                i = i - 1;
            }
        }
        return height;
    }

    public static double getUserWeight (){
        double weight = 1;
        Scanner input = new Scanner(System.in);
        int i;

        for (i = 0; i < 1; i++) {

            System.out.print("Enter your weight: \n");

            weight = input.nextDouble();

            if (weight <= 0) {
                System.out.print("Error: Input must be a positive value.\n");
                i = i - 1;
            }
        }
        input.nextLine();
        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex bmi) {
        double BMI;
        String BMIcategory;

        BMI = bmi.calculateScore(bmi);

        BMIcategory = bmi.calculateCategory(bmi);

        System.out.print("BMI: " + BMI + "  Category: " + BMIcategory + "\n");

    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        int i;
        int n;
        double BMI;
        double totalBMI = 0;
        double averageBMI;

        n = bmiData.size();

        for (i = 0; i < n; i++)
        {
            BMI = bmiData.get(i).calculateScore(bmiData.get(i));

            totalBMI = totalBMI + BMI;
        }

        averageBMI = totalBMI / n;

        System.out.print("Average BMI score: " + averageBMI + "\n");
    }

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
}
