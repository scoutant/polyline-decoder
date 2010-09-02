/**
 * Reimplementation of Mark McClures Javascript PolylineEncoder
 * All the mathematical logic is more or less copied by McClure
 *  
 * @author Mark Rambow
 * @e-mail markrambow[at]gmail[dot]com
 * @version 0.1
 * 
 */

package it.rambow.master.javautils;

public class Trackpoint {
    private double latDouble;
    private double lonDouble;
    private double altitude;

	public Trackpoint(double lat, double lon) {
        this.latDouble = lat;
        this.lonDouble = lon;
    }
	public Trackpoint(double lat, double lon, double altitude) {
        this.latDouble = lat;
        this.lonDouble = lon;
        this.altitude  = altitude;
    }

    public void setLatDouble(double latDouble) {
        this.latDouble = latDouble;
    }

    public void setLonDouble(double lonDouble) {
        this.lonDouble = lonDouble;
    }

    public double getLatDouble() {
        return latDouble;
    }

    public double getLonDouble() {
        return lonDouble;
    }

    public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

}
