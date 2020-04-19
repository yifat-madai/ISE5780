package Geometries;

import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class geometriesTest {



    @Test
    public void findIntersections()
    {
      //check if list is null
        try
        {
            Ray r=new Ray(new Point3D(1,1,0),new Vector(1,1,1));
            geometries g=new geometries();
            g.findIntersections(r);

            fail("list is null");
        } catch (IllegalArgumentException ex) {
            assertEquals("list is null", ex.getMessage());
        }
        assertTrue(true);

//no shapes intersection
        Ray r=new Ray(new Point3D(1,1,0),new Vector(1,1,1));
        geometries g =new geometries();
        List<Point3D>l=g.findIntersections(r);
        assertEquals(0,l.size());

        //one shapes intersection

        Ray r1=new Ray(new Point3D(1,1,0),new Vector(1,1,1));
        geometries g1 =new geometries();
        l=g.findIntersections(r);
        assertEquals(1,l.size());







    }
}