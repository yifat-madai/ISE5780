package Geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;

public class Triangle extends Polygon {

    /**
     * @param vertices creates new triangle
     */
    public Triangle(Point3D... vertices) {
        super(vertices);
    }

    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
