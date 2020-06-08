package de.ihrigb.commons;

/**
 * Java Objects Utils.
 */
public final class Objects {

	/**
	 * Null-safe equals for two objects. Uses Object::equals method.
	 *
	 * @param obj0 first object
	 * @param obj1 second object
	 * @return true if both values are equals (also for obj0 == null && obj1 ==
	 *         null)
	 */
	public static boolean equals(Object obj0, Object obj1) {
		if (obj0 == null && obj1 == null) {
			return true;
		}
		return obj0 != null && obj0.equals(obj1);
	}

	private Objects() {
	}
}
