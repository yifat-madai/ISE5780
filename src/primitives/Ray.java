package primitives;

import java.util.Objects;

public class Ray {
    private primitives.Point3D _p;
    private Vector _v;

    /**
     * @param _p
     * @param _v creates new ray
     */
    public Ray(primitives.Point3D _p, Vector _v) {
        this._p = _p;
        this._v = _v;
        if (_v.length() != 1)
            _v = _v.normalize();
    }

    /**
     * @return the point of the ray
     */
    public primitives.Point3D get_p() {
        return _p;
    }

    /**
     * @return the vector of the ray
     */
    public Vector get_v() {
        return _v;
    }

    /**
     * @return the ray details
     */
    @Override
    public String toString() {
        return "Ray{" +
                "_p=" + _p +
                ", _v=" + _v +
                '}';
    }

    /**
     * @param o
     * @return true if the object and the ray are equals and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return Objects.equals(_p, ray._p) &&
                Objects.equals(_v, ray._v);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_p, _v);
    }

    public Point3D getTargetPoint(double length) {
        return Util.isZero(length) ? _p : _p.add(_v.scale(length));
    }
}
