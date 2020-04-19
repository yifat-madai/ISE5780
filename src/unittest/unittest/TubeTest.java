package unittest;

import org.junit.Test;
import primitives.*;
import Geometries.*;


import static org.junit.Assert.*;

public class TubeTest {

    @Test
    public void getNormal() {
        Point3D center = new Point3D(0, 0, 0);
        Vector direction = new Vector(0, 0, 1);
        Ray ray = new Ray(center, direction);
        Tube tube = new Tube(25, ray);

        Point3D p = new Point3D(25, 0, 1);

        double t = p.substract(center).dotProduct(direction);

        Point3D o = null;
        if (!Util.isZero(t))
            o = center.add(direction.scale(t));

        //============ Equivalence Partitions Tests ==============
        Vector n = (p.substract(o)).normalize();
        Vector exRes = new Vector(1, 0, 0);

        assertEquals("ERROR, Tube's GetNormal() - wrong result ", exRes, n);
    }
}