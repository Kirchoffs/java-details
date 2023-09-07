package org.syh.jackson.jsontypeinfo;

public class Circle extends Shape {
    private int r;

    public Circle(int r) {
        this.r = r;
    }

    public Circle() {}

    public static Circle of(int r) {
        return new Circle(r);
    }

    @Override
    public String toString() {
        return String.format("Circle: {r = %d}", r);
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getR() {
        return r;
    }
}
