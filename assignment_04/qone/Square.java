package qone;

class Square extends Shape {
    public Square(double side) {
        this.name = "Square";
        this.perimeter = 4 * side;
        this.area = side * side;
    }
}
