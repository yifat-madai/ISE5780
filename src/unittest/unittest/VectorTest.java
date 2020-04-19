package unittest;

import org.junit.Test;

import static org.junit.Assert.*;

import primitives.Vector;

public class VectorTest {

    @Test
    public void substract() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.5);

        v1 = v1.substract(v2);
        assertEquals(new Vector(2.0, 2.0, 2.5), v1);

        v2 = v2.substract(v1);
        assertEquals(new Vector(-3.0, -3.0, -4.0), v2);


        try {
            Vector v3 = new Vector(0, 0, 0);
            v3.substract(v1);
            fail("vector 0 is not valid");
        } catch (IllegalArgumentException ex) {
            assertEquals("cannot accept zero", ex.getMessage());
        }
        assertTrue(true);

        try {
            Vector v4 = new Vector(1, 1, 1);
            Vector v5 = new Vector(1, 1, 1);
            v4.substract(v5);
            fail("vector 0 is not valid");
        } catch (IllegalArgumentException ex) {
            assertEquals("cannot accept zero", ex.getMessage());
        }
        assertTrue(true);

    }


    @Test
    public void add() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.5);

        v1 = v1.add(v2);
        assertEquals(new Vector(0.0, 0.0, -0.5), v1);

        v2 = v2.add(v1);
        assertEquals(new Vector(-1.0, -1.0, -2.0), v2);

        try {
            Vector v3 = new Vector(0, 0, 0);
            v3.add(v1);
            fail("vector 0 is not valid");
        } catch (IllegalArgumentException ex) {
            assertEquals("cannot accept zero", ex.getMessage());
        }
        assertTrue(true);

        try {
            Vector v4 = new Vector(1, 1, 1);
            Vector v5 = new Vector(-1, -1, -1);
            v4.add(v5);
            fail("vector 0 is not valid");
        } catch (IllegalArgumentException ex) {
            assertEquals("cannot accept zero", ex.getMessage());
        }
        assertTrue(true);

    }


    @Test
    public void scale() {
        Vector v1 = new Vector(1, 1, 1);

        Vector v1test = v1.scale(1);
        assertEquals(new Vector(1, 1, 1), v1test);

        Vector v2test = v1test.scale(2);
        assertEquals(new Vector(2, 2, 2), v2test);

        Vector v3test = v2test.scale(-2);
        assertEquals(new Vector(-4, -4, -4), v3test);

        try {
            Vector v3 = new Vector(0, 0, 0);
            v3.scale(4);
            fail("vector 0 is not valid");
        } catch (IllegalArgumentException ex) {
            assertEquals("cannot accept zero", ex.getMessage());
        }
        assertTrue(true);
    }

    @Test
    public void dotProduct() {
        Vector v = new Vector(2, 3, 4);
        Vector v2 = new Vector(1, 3, 2);
        assertEquals(19, v.dotProduct(v2), 0);

        try {
            Vector v3 = new Vector(0, 0, 0);
            v3.dotProduct(v);
            fail("vector 0 is not valid");
        } catch (IllegalArgumentException ex) {
            assertEquals("cannot accept zero", ex.getMessage());
        }
        assertTrue(true);


    }

    @Test
    public void crossProduct() {

        Vector v1 = new Vector(3.5, -5.0, 10.0);
        Vector v2 = new Vector(2.5, 7, 0.5);
        Vector v3 = v1.crossProduct(v2);

        assertEquals(0, v3.dotProduct(v2), 1e-10);
        assertEquals(0, v3.dotProduct(v1), 1e-10);

        Vector v4 = v2.crossProduct(v1);

        System.out.println(v3.toString());
        System.out.println(v4.toString());

        try {
            v3.add(v4);
            fail("Vector (0,0,0) not valid");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage() != null);
        }
//        assertTrue(v3.length() >84);
        assertEquals(84, v3.length(), 0.659);
    }

    @Test
    public void lengthSquared() {
        Vector v = new Vector(2, 3, 4);
        assertEquals(29, v.lengthSquared(), 0);

        try {
            Vector v3 = new Vector(0, 0, 0);
            double ans = v3.lengthSquared();
            fail("vector 0 is not valid");
        } catch (IllegalArgumentException ex) {
            assertEquals("cannot accept zero", ex.getMessage());
        }
        assertTrue(true);
    }

    @Test
    public void length() {
        Vector v = new Vector(2, 3, 4);
        assertEquals(Math.sqrt(29), v.length(), 0);

        try {
            Vector v3 = new Vector(0, 0, 0);
            double ans = v3.length();
            fail("vector 0 is not valid,cannot divide by 0");
        } catch (IllegalArgumentException ex) {
            assertEquals("cannot accept zero", ex.getMessage());
        }
        assertTrue(true);
    }

    @Test
    public void normalize() {
        Vector v = new Vector(3.5, -5, 10);
        v.normalize();
        assertEquals(1, v.length(), 1e-10);

        try {
            Vector v1 = new Vector(0, 0, 0);
            v.normalize();
            fail("Didn't throw divide by zero exception!");
        } catch (IllegalArgumentException ex) {
            assertEquals("cannot accept zero", ex.getMessage());
        }
        assertTrue(true);
    }

    @Test
    public void normalized() {
        Vector v = new Vector(2, 3, 4);
        Vector v1 = v.normalized();
        assertEquals(1, v1.length(), 1e-10);
    }


}