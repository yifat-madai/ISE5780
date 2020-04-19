package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import primitives.Util;

import java.util.List;

public class Tube extends RadialGeometry {
    private Ray _axisRay;

    public Tube(double _radius, Ray _axisRay) {
        super(_radius);
        this._axisRay = _axisRay;
    }

    /**
     *
     * @param _radius
     * @param _axisRay
     * creates new tube
     */


    /**
     * @param point
     * @return the normal to the tube
     */
    public Vector getNormal(Point3D point) {
        Point3D o = _axisRay.get_p(); // at this point o = p0
        Vector v = _axisRay.get_v();

        Vector vector1 = point.substract(o);

        //We need the projection to multiply the _direction unit vector
        double projection = vector1.dotProduct(v);
        if (!Util.isZero(projection)) {
            // projection of P-O on the ray:
            o = o.add(v.scale(projection));
        }

        //This vector is orthogonal to the _direction vector.
        Vector check = point.substract(o);
        return check.normalize();
    }


    /**
     * @return the ray of the tube
     */

    public Ray get_axisRay() {
        return _axisRay;
    }

    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
