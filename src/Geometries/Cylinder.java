package Geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;

import java.util.List;

public class Cylinder extends Tube {
    private double height;

    public Cylinder(double _radius, Ray _axisRay, double height) {
        super(_radius, _axisRay);
        this.height = height;
    }


    /**
     *
     * @param _radius
     * @param height
     * creates new cylinder
     */


    /**
     * @param point
     * @return the normal of the cylinder
     */
    public Vector getNormal(Point3D point) {
        Point3D o = get_axisRay().get_p();
        Vector v = get_axisRay().get_v();

        // projection of P-O on the ray:
        double t;
        try {
            t = Util.alignZero(point.substract(o).dotProduct(v));
        } catch (IllegalArgumentException e) { // P = O
            return v;
        }

        // if the point is at a base
        if (t == 0 || Util.isZero(height - t)) // if it's close to 0, we'll get ZERO vector exception
            return v;

        o = o.add(v.scale(t));
        return point.substract(o).normalize();
    }

    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }


}

