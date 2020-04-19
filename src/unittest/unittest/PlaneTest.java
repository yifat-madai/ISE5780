package unittest;

import Geometries.Plane;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.Assert.*;

public class PlaneTest {

    @Test
    public void getNormal() {
        Point3D p1 = new Point3D(1, 0, 0);
        Point3D p2 = new Point3D(0, 1, 0);
        Point3D p3 = new Point3D(0, 0, 1);
        Vector v1 = new Vector(p1);
        Vector v2 = new Vector(p2);
        Vector v3 = new Vector(p3);

        Vector n = new Vector((v1.substract(v2)).crossProduct(v3.substract(v2))).normalized().scale(-1);
        assertEquals(new Vector(0.5773502691896258, 0.5773502691896258, 0.5773502691896258), n);


    }
}