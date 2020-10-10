abstract class Shape3D extends Shape {
    abstract double getVolume();
}

class Cube extends Shape3D {
    double length;
    Cube(double length) {
        this.length = length;
    }
    @Override
    String getName() {
        String shapeName;

        shapeName = "cube";

        return shapeName;
    }
    @Override
    double getArea() {
        double surfaceArea;

        surfaceArea = this.length * this.length * 6;

        return surfaceArea;
    }
    @Override
    double getVolume() {
        double volume;

        volume = this.length * this.length * this.length;

        return volume;
    }
}

class Pyramid extends Shape3D {
    double length;
    double width;
    double height;
    Pyramid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    @Override
    String getName() {
        String shapeName;

        shapeName = "pyramid";

        return shapeName;
    }
    @Override
    double getArea() {
        double surfaceArea;
        double slantHeight1;
        double slantHeight2;

        slantHeight1 = Math.sqrt((0.5 * this.width) * (0.5 * this.width) + (this.height * this.height));

        slantHeight2 = Math.sqrt((0.5 * this.length) * (0.5 * this.length) + (this.height * this.height));

        surfaceArea = (this.length * this.width) + (this.length * slantHeight1) + (this.width * slantHeight2);

        return surfaceArea;
    }
    @Override
    double getVolume() {
        double volume;

        volume = (1d/3d) * this.length * this.width * this.height;

        return volume;
    }
}

class Sphere extends Shape3D {
    double radius;
    Sphere(double radius) {
        this.radius = radius;
    }
    @Override
    String getName() {
        String shapeName;

        shapeName = "sphere";

        return shapeName;
    }
    @Override
    double getArea() {
        double surfaceArea;

        surfaceArea = 4 * 3.14159 * (this.radius * this.radius);

        return surfaceArea;
    }
    @Override
    double getVolume() {
        double volume;

        volume = (4d/3d) * 3.14159 * (this.radius * this.radius * this.radius);

        return volume;
    }
}
