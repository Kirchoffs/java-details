package org.syh.jackson.jsontypeinfo;

import java.util.List;

public class View {
    private List<Shape> shapes;

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("View: [");
        if (shapes != null) {
            for (Shape shape: shapes) {
                sb.append(shape.toString());
                sb.append(", ");
            }
        }
        if (sb.length() > 2) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
