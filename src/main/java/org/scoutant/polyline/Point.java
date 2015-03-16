package org.scoutant.polyline;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * Simple geographical point represented by a couple of doubles. Google's GeoPoint is a couple of micro-degrees
 * represented by integers.
 */
public class Point implements Serializable {
    private static final long serialVersionUID = 1L;
    private final double lat;
    private final double lng;

    public Point(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "(" + lat + ", " + lng + ")";
    }

    /**
     * Utility method to export coordinates for use with GeoJSON. This standard requires longitude first. See
     * http://geojson.org/geojson-spec.html#positions
     */
    public static String toGeoJSON(List<Point> points) {
        StringBuilder buff = new StringBuilder("[");
        Iterator<Point> itr = points.iterator();
        while (itr.hasNext()) {
            buff.append(toGeoJSON(itr.next()));
            if (itr.hasNext()) {
                buff.append(",");
            }
        }
        buff.append("]");
        return buff.toString();
    }

    public static String toGeoJSON(Point point) {
        return "[" + point.getLng() + "," + point.getLat() + "]";
    }

    /**
     * We consider that two point are equals if both latitude and longitude are "nearly" the same. With a precision of
     * 1e-3 degree
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        Point that = (Point) o;
        if (Math.abs(that.getLat() - lat) > 0.001) {
            return false;
        }
        return Math.abs(that.getLng() - lng) <= 0.001;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.lat) ^ (Double.doubleToLongBits(this.lat) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.lng) ^ (Double.doubleToLongBits(this.lng) >>> 32));
        return hash;
    }

}
