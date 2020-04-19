package primitives;

import java.util.Objects;

public class Vector {


    private primitives.Point3D _head;

    /**
     * c-tor that creates new vector by 3 coordinates
     *
     * @param x
     * @param y
     * @param z
     */
    public Vector(primitives.Coordinate x, primitives.Coordinate y, primitives.Coordinate z) {
        primitives.Point3D check = new primitives.Point3D(x, y, z);
        if (check.equals(primitives.Point3D.ZERO))
            throw new IllegalArgumentException("cannot accept zero");
        this._head = new primitives.Point3D(check);
    }

    /**
     * c-tor that creates new vector by 3 floats numbers
     *
     * @param x
     * @param y
     * @param z
     */
    public Vector(double x, double y, double z) {
        primitives.Point3D check = new primitives.Point3D(x, y, z);
        if (check.equals(primitives.Point3D.ZERO)) {

            throw new IllegalArgumentException("cannot accept zero");
        }
        this._head = new primitives.Point3D(check);
    }

    /**
     * c-tor that creates new vector by Point3D
     *
     * @param end
     */
    public Vector(primitives.Point3D end) {
        if (end.equals(primitives.Point3D.ZERO))
            throw new IllegalArgumentException("cannot accept zero");
        this._head = end;
    }

    /**
     * copy c-tor
     *
     * @param vector
     */
    public Vector(Vector vector) {
        this._head = new primitives.Point3D(vector._head);
    }

    /**
     * @return the head point of the vector
     */
    public primitives.Point3D get_head() {
        return _head;
    }

    /**
     * @param vector
     * @return new vector which is the sub between the two vectors
     */
    public Vector substract(Vector vector) {
        return new Vector(this._head.getX().get() - vector._head.getX().get(), this._head.get_y().get() - vector._head.get_y().get(), this._head.get_z().get() - vector._head.get_z().get());
    }

    /**
     * @param vector
     * @return new vector which is the sum between the two vectors
     */

    public Vector add(Vector vector) {
        return new Vector(vector._head.getX().get() + this._head.getX().get(), vector._head.get_y().get() + this._head.get_y().get(), vector._head.get_z().get() + this._head.get_z().get());
    }

    /**
     * @param num
     * @return new vector: a*V when a is a number and v is vector (multipile the vector by scalar)
     */

    public Vector scale(double num) {
        return new Vector(num * (this._head.getX().get()), num * (this._head.get_y().get()), num * (this._head.get_z().get()));
    }

    /**
     * @param vector
     * @return
     */
    public double dotProduct(Vector vector) {
        return (this._head.getX().get() * vector._head.getX().get() + this._head.get_y().get() * vector._head.get_y().get() + this._head.get_z().get() * vector._head.get_z().get());

    }


    /**
     * @param vector
     * @return new vector that is the cross vector between the two vector
     */
    public Vector crossProduct(Vector vector) {
        return new Vector((this._head.get_y().get() * vector._head.get_z().get()) - (this._head.get_z().get() * vector._head.get_y().get()), this._head.get_z().get() * vector._head.getX().get() - this._head.getX().get() * vector._head.get_z().get(), this._head.getX().get() * vector._head.get_y().get() - this._head.get_y().get() * vector._head.getX().get());

    }

    /**
     * @return the squrared length of the vector
     */
    public double lengthSquared() {
        return (this._head.getX().get() * this._head.getX().get() + this._head.get_y().get() * this._head.get_y().get() + this._head.get_z().get() * this._head.get_z().get());
    }

    /**
     * @return the length of the vector
     */
    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    /**
     * @return the vector after normalizing
     */

    public Vector normalize() {
        primitives.Point3D point = new primitives.Point3D(this._head.getX().get() / this.length(), this._head.get_y().get() / this.length(), this._head.get_z().get() / this.length());
        this._head = point;
        return this;
    }

    /**
     * @return new normalize vector
     */
    public Vector normalized() {
        return new Vector(this._head.getX().get() / this.length(), this._head.get_y().get() / this.length(), this._head.get_z().get() / this.length());
    }

    /**
     * @return the vector details
     */
    @Override
    public String toString() {
        return "Vector{" +
                "end=" + _head +
                '}';
    }

    /**
     * @param o
     * @return true if o is the same vector as this and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(_head, vector._head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_head);
    }
}
