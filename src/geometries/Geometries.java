package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public class Geometries implements Intersectable {
    public List<Intersectable> getList() {
        return list;
    }

    private List<Intersectable> list;

    public Geometries() {
        this.list = new ArrayList<>();
    }

    public Geometries(Intersectable... Geometries) {

        for (Intersectable intersectable : Geometries) {
            list = new ArrayList<>(Geometries.length);
            list.add(intersectable);
        }

    }

    public void add(Intersectable... Geometries) {
        for (Intersectable intersectable : Geometries) {
            list.add(intersectable);
        }
    }

    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }

}
