package qone;

class Rectangle extends Shape {
    public Rectangle(double width, double height) {
        this.name = "Rectangle";
        this.perimeter = 2 * (width + height);
        this.area = width * height;
    }
}
