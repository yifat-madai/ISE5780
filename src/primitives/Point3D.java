package primitives;

import java.util.Objects;

public class Point3D {
    private primitives.Coordinate _x;
    private primitives.Coordinate _y;
    private primitives.Coordinate _z;
/********************************constructors*************************************/

    /**
     * Point3D constructor receiving three coordinates values
     *
     * @param x
     * @param y
     * @param z
     */
    public Point3D(primitives.Coordinate x, primitives.Coordinate y, primitives.Coordinate z) {
        this._x = new primitives.Coordinate(x);
        this._y = new primitives.Coordinate(y);
        this._z = new primitives.Coordinate(z);
    }


    /**
     * point3D constructor receiving three floats values
     *
     * @param x
     * @param y
     * @param z
     */
    public Point3D(double x, double y, double z) {
        this._x = new primitives.Coordinate(x);
        this._y = new primitives.Coordinate(y);
        this._z = new primitives.Coordinate(z);
    }


    /**
     * point3D constructor receiving other point3D
     *
     * @param point
     */
    public Point3D(Point3D point) {
        this._x = new primitives.Coordinate(point._x.get());
        this._y = new primitives.Coordinate(point._y.get());
        this._z = new primitives.Coordinate(point._z.get());
    }


    //vector 0 definition
    public final static Point3D ZERO = new Point3D((new primitives.Coordinate(0.0)), (new primitives.Coordinate(0.0)), (new primitives.Coordinate(0.0)));

/*******************************getter*************************/

    /**
     * @return the value of x
     */
    public primitives.Coordinate getX() {
        return _x;
    }


    /**
     * @return the value of y
     */
    public primitives.Coordinate get_y() {
        return _y;
    }

    /**
     * @return the value of z
     */
    public primitives.Coordinate get_z() {
        return _z;
    }


    /**
     * compares between point3D to other object
     *
     * @param o
     * @return true if both of the       are equals and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return Objects.equals(_x, point3D._x) &&
                Objects.equals(_y, point3D._y) &&
                Objects.equals(_z, point3D._z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_x, _y, _z);
    }

    /**
     * @return string with the point3D details
     */
    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + _x +
                ", y=" + _y +
                ", z=" + _z +
                '}';
    }

    /**
     * substract between two points3D
     *
     * @param point
     * @return new vector which is the sub between two points3D
     */
    public Vector substract(Point3D point) {
        //  return new Vector(new Point3D((this.getX()).get()-(point.getX()).get(),((this.getY()).get())-(point.getY()).get(),(this.getZ()).get()-(point.getZ()).get()));
        Point3D ans = new Point3D(this.getX().get() - point.getX().get(), this.get_y().get() - point.get_y().get(), this.get_z().get() - point.get_z().get());
        return new Vector(ans);

    }

    /**
     * @param point
     * @return new point3D with the sum of the two points3D
     */

    public Point3D add(Point3D point) {
        return new Point3D(this.getX().get() + point.getX().get(), this.get_y().get() + point.get_y().get(), this.get_z().get() + point.get_z().get());
    }

    /**
     * @param V
     * @return new point3D with the sum between point3D and  vector
     */
    public Point3D add(Vector V) {
        return new Point3D(this.getX().get() + V.get_head().getX().get(), this.get_y().get() + V.get_head().get_y().get(), this.get_z().get() + V.get_head().get_z().get());
    }

    /**
     * @param point
     * @return the srquare of the distance between two points3D
     */
    public double distanceSquared(Point3D point) {
        return (((this.getX().get() - point.getX().get()) * ((this.getX().get() - point.getX().get())) + ((this.get_y().get() - point.get_y().get()) * ((this.get_y().get() - point.get_y().get()))) + ((this.get_z().get() - point.get_z().get()) * ((this.get_z().get() - point.get_z().get())))));
    }

    /**
     * @param point
     * @return the the distance between two points3D
     */

    public double distance(Point3D point) {
        return Math.sqrt(distanceSquared(point));
    }

}
