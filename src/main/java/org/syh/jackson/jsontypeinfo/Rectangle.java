package org.syh.jackson.jsontypeinfo;

public class Rectangle extends Shape {
    private int w;
    private int h;

    public Rectangle(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public Rectangle() {}

    public static Rectangle of(int w, int h) {
        return new Rectangle(w, h);
    }

    @Override
    public String toString() {
        return String.format("Rectangle: {w = %d, h = %d}", w, h);
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
