package geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.Assert.*;

public class geometriesTest {



    @Test
    public void findIntersections()
    {
      //check if list is null
        try
        {
            Ray r = new Ray(new Point3D(1, 1, 0), new Vector(1, 1, 1));
            Geometries g = new Geometries();
            g.findIntersections(r);

            fail("list is null");
        } catch (IllegalArgumentException ex) {
            assertEquals("list is null", ex.getMessage());
        }
        assertTrue(true);

//no shapes intersection
        Ray r = new Ray(new Point3D(1, 1, 0), new Vector(1, 1, 1));
        Geometries g = new Geometries();
        List<Point3D> l = g.findIntersections(r);
        assertEquals(0,l.size());

        //one shapes intersection

        Ray r1 = new Ray(new Point3D(1, 1, 0), new Vector(1, 1, 1));
        Geometries g1 = new Geometries();
        l=g.findIntersections(r);
        assertEquals(1,l.size());







    }
}