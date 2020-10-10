abstract class Shape2D extends Shape {
}

class Square extends Shape2D {
    double base;
    Square (double base) {
        this.base = base;
    }
    @Override
    String getName() {
        String shapeName;

        shapeName = "square";

        return shapeName;
    }

    @Override
    double getArea() {
        double area;

        area = this.base * this.base;

        return area;
    }
}
class Triangle extends Shape2D {
    double base;
    double height;
    Triangle (double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    String getName() {
        String shapeName;

        shapeName = "triangle";

        return shapeName;
    }
    @Override
    double getArea() {
        double area;

        area = (this.base * this.height) / 2;

        return area;
    }
}
class Circle extends Shape2D {
    double radius;
    Circle (double radius) {
        this.radius = radius;
    }
    @Override
    String getName() {
        String shapeName;

        shapeName = "circle";

        return shapeName;
    }
    @Override
    double getArea() {
        double area;

        area = 3.14159 * (this.radius * this.radius);

        return area;
    }
}