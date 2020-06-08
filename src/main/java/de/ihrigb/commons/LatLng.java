package de.ihrigb.commons;

/**
 * Class to represent a latitude/longitude coordinate (WGS84).
 */
public final class LatLng {

	/**
	 * Calculate haversine distance.
	 *
	 * @param start start LatLng
	 * @param end   end LatLng
	 * @return distance between two points
	 */
	public static Distance distance(LatLng start, LatLng end) {
		return Haversine.distance(start, end);
	}

	private final double lat;
	private final double lng;

	/**
	 * Construct a LatLng by values.
	 *
	 * @param lat latitude
	 * @param lng longitude
	 */
	public LatLng(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	/**
	 * Get the latitude value.
	 *
	 * @return latitude
	 */
	public double getLatitude() {
		return this.lat;
	}

	/**
	 * Get the longitude value.
	 *
	 * @return longitude
	 */
	public double getLongitude() {
		return this.lng;
	}

	/**
	 * Get radians representation of LatLng.
	 *
	 * @return latitude and longitude as radians
	 */
	public Radians getRadians() {
		return new Radians(this);
	}

	/**
	 * Calculate the haversine distance to another point.
	 *
	 * @param other target point
	 * @return haversine distence
	 */
	public Distance getDistanceTo(LatLng other) {
		return LatLng.distance(this, other);
	}

	/**
	 * Radians representation of LatLng.
	 */
	public final class Radians {

		private final LatLng latLng;

		private Radians(LatLng latLng) {
			this.latLng = latLng;
		}

		/**
		 * Get latitude as radian.
		 *
		 * @return latitude as radian
		 */
		public double getLatitude() {
			return Math.toRadians(this.latLng.lat);
		}

		/**
		 * Get longitude as radian.
		 *
		 * @return longitude as radian
		 */
		public double getLongitude() {
			return Math.toRadians(this.latLng.lng);
		}
	}
}
