package org.scoutant.polyline;

import java.util.List;

public class PolylineUtils {

	public static String toString(List<Point> polyline) {
		String str = "[ ";
		for( Point p : polyline) {
			str += p;
		}
		return str + " ]";
	}

	public static String toMarkers(List<Point> polyline) {
		String str = "";
		for( Point p : polyline) {
			str += "|" + p.getLat()+","+p.getLng();
		}
		return str.substring(1, str.length());
	}

}
