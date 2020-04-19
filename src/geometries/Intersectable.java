package geometries;

import primitives.Ray;
import primitives.Point3D;

import java.util.List;;

public interface Intersectable {
    public List<Point3D> findIntersections(Ray ray);
}
