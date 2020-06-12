package de.ihrigb.commons;

import java.util.Optional;
import java.util.function.Function;

/**
 * Java Objects Utils.
 */
public final class Objects {

	/**
	 * Null-safe equals for two objects. Uses Object::equals method.
	 *
	 * @param obj0 first object
	 * @param obj1 second object
	 * @return true if both values are equals (also for obj0 == null &amp;&amp; obj1
	 *         == null)
	 */
	public static boolean equals(Object obj0, Object obj1) {
		if (obj0 == null && obj1 == null) {
			return true;
		}
		return obj0 != null && obj0.equals(obj1);
	}

	/**
	 * Maps an object if it is not null.
	 *
	 * @param <T>    type of the input value
	 * @param <R>    type of the return value
	 * @param value  input value
	 * @param mapper function to map to R
	 * @return null, if value is null; otherwise result of the mapper
	 */
	public static <T, R> R mapIfNotNull(T value, Function<T, R> mapper) {
		return Optional.ofNullable(value).map(mapper).orElse(null);
	}

	private Objects() {
	}
}
