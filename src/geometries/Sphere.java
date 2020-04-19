package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public class Sphere extends RadialGeometry {
    private Point3D center;

    /**
     * @param _radius
     * @param center  creates new sphere
     */
    public Sphere(double _radius, Point3D center) {
        super(_radius);
        this.center = center;
    }

    /**
     * @param point
     * @return the normal of the triangle
     */
    public Vector getNormal(Point3D point) {
        return new Vector((point.substract(this.center))).normalized();

    }

    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }

}

