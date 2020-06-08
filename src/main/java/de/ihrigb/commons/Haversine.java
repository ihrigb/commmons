package de.ihrigb.commons;

/**
 * Utils to calculate haversine distances of two points on earth (WGS84).
 */
public final class Haversine {

	/**
	 * Calculate haversine distance.
	 *
	 * @param latStart start latitude
	 * @param lngStart start longitude
	 * @param latEnd   end latitude
	 * @param lngEnd   end longitude
	 * @return distance between two points
	 */
	public static Distance distance(double latStart, double lngStart, double latEnd, double lngEnd) {
		return distance(new LatLng(latStart, lngStart), new LatLng(latEnd, lngEnd));
	}

	/**
	 * Calculate haversine distance.
	 *
	 * @param start start LatLng
	 * @param end   end LatLng
	 * @return distance between two points
	 */
	public static Distance distance(LatLng start, LatLng end) {
		final double dLat = end.getRadians().getLatitude() - start.getRadians().getLatitude();
		final double dLng = end.getRadians().getLongitude() - start.getRadians().getLongitude();

		final double a = haversin(dLat) + Math.cos(start.getRadians().getLatitude())
				* Math.cos(end.getRadians().getLatitude()) * haversin(dLng);
		final double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return Constants.MEAN_EARTH_RADIUS.multiply(c);
	}

	private static double haversin(double val) {
		return Math.pow(Math.sin(val / 2), 2);
	}

	private Haversine() {
	}
}
