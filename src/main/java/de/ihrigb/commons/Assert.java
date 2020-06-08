package de.ihrigb.commons;

import java.util.function.Supplier;

/**
 * Parameter Assertion Utils.
 */
public final class Assert {

	/**
	 * Expect obj to be not null. Otherwise throws exception provided by
	 * exceptionSupplier.
	 *
	 * @param obj               object to be checked against null
	 * @param exceptionSupplier supplies the exception if obj is null
	 */
	public static void notNull(Object obj, Supplier<? extends RuntimeException> exceptionSupplier) {
		if (obj == null) {
			throw exceptionSupplier.get();
		}
	}

	/**
	 * Expect obj to be not null. Otherwise throws IllegalArgumentException with
	 * message.
	 *
	 * @param obj     object to be checked against null
	 * @param message message for the exception
	 */
	public static void notNull(Object obj, String message) {
		Assert.notNull(obj, () -> new IllegalArgumentException(message));
	}

	private Assert() {
	}
}
