package qone;

class Circle extends Shape {
    public Circle(double radius) {
        this.name = "Circle";
        this.perimeter = 2 * Math.PI * radius;
        this.area = Math.PI * radius * radius;
    }
}
