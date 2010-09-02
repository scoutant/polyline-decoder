package org.scoutant.polyline;

import java.io.Serializable;

/**
 * Simple geographical point represented by a couple of doubles. 
 * Google's GeoPoint is a couple of micro-degrees represented by integers. 
 */
public class Point implements Serializable {
	private static final long serialVersionUID = 1L;
	private double lat;
	private double lng;
	
	public Point(double lat, double lng) {
		this.lat=lat;
		this.lng=lng;
	}
	
	public double getLat(){
		return lat; 
	}
	public double getLng(){
		return lng;
	}
	@Override
	public String toString(){
		return "("+lat+", "+lng+")"; 
	}

	/**
	 * We consider that two point are equals if both latitude and longitude are "nearly" the same. 
	 * With a precision of 1e-3 degree 
	 */

	@Override
	public boolean equals(Object o){
		if ( ! (o instanceof Point)) return false;
		Point that = (Point)o;
		if (Math.abs( that.getLat() - lat) > 0.001) return false;
		if (Math.abs( that.getLng() - lng) > 0.001) return false;
		return true;
	}
	
	
}
