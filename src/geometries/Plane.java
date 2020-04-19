package geometries;

import primitives.Point3D;
import primitives.Vector;
import primitives.Ray;

import java.util.List;


public class Plane implements Geometry {
    private Vector _normal;
    private Point3D _p;

    /**
     * @param vector
     * @param point  creates plane by vector and point
     */
    public Plane(Vector vector, Point3D point) {
        this._normal = vector;
        this._p = point;
    }

    /**
     * @param p1
     * @param p2
     * @param p3 creates plane by 3 points
     */
    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        Vector v1 = new Vector(p1);
        Vector v2 = new Vector(p2);
        Vector v3 = new Vector(p3);
        _normal = ((v1.substract(v2)).crossProduct(v3.substract(v2))).normalized().scale(-1);
        _p = p3;
    }


    /**
     * @param point
     * @return the normal of the plane
     */
    public Vector getNormal(Point3D point) {
        return _normal;
    }

    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }


}
