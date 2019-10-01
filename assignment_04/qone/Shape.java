package qone;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Shape {
    String name;
    double perimeter;
    double area;
    public Shape() {
        this.name = "Shape";
    }

    public void draw() {
        System.out.println("Drawing " + this.name);
    }
    public double getArea() {
        BigDecimal bd = new BigDecimal(this.area).setScale(2, RoundingMode.DOWN);
        System.out.println(bd.doubleValue());
        return this.area;
    }
    public double getPerimeter() {
        BigDecimal bd = new BigDecimal(this.perimeter).setScale(2, RoundingMode.DOWN);
        System.out.println(bd.doubleValue());
        return this.perimeter;
    }
}
