public class BodyMassIndex {
    double height;
    double weight;

    public BodyMassIndex(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double calculateScore(BodyMassIndex bmi) {
        double BMI;
        double scale = 10;

        BMI = 703 * bmi.weight / (bmi.height * bmi.height);

        BMI = Math.round(BMI * scale) / scale;

        return BMI;
    }

    public String calculateCategory(BodyMassIndex bmi) {
        double BMI;
        String BMIcategory;

        BMI = calculateScore(bmi);

        if (BMI < 18.5)
        {
            BMIcategory = "Underweight";
        }

        else if (BMI >= 18.5 && BMI < 25)
        {
            BMIcategory = "Normal weight";
        }

        else if (BMI >= 25 && BMI < 30)
        {
            BMIcategory = "Overweight";
        }

        else if (BMI >= 30)
        {
            BMIcategory = "Obesity";
        }

        else
        {
            BMIcategory = "Unknown??";
        }

        return BMIcategory;
    }
}
