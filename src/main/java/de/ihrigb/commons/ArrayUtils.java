package de.ihrigb.commons;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Utils to work with arrays.
 */
public final class ArrayUtils {

	/**
	 * Searches the array for an element and returns an optional index.
	 *
	 * @param <T>    array type
	 * @param array  array to search
	 * @param needle needle to be searched for
	 * @return first index of needle or empty optional.
	 */
	public static <T> Optional<Integer> optionalIndexOf(T[] array, T needle) {
		if (array == null || array.length == 0) {
			return Optional.empty();
		}

		for (int i = 0; i < array.length; i++) {
			T atIndex = array[i];
			if ((needle == null && atIndex == null) || (needle != null && needle.equals(atIndex))) {
				return Optional.of(i);
			}
		}

		return Optional.empty();
	}

	/**
	 * Searches the index of an element 'needle'.
	 *
	 * @param <T>    array type
	 * @param array  array to search
	 * @param needle needle to be searched for
	 * @return first index of needle or -1 if not found.
	 */
	public static <T> int indexOf(T[] array, T needle) {
		return ArrayUtils.optionalIndexOf(array, needle).orElse(-1);
	}

	/**
	 * Checks if an array contains an element.
	 *
	 * @param <T>    array type
	 * @param array  array to search
	 * @param needle needle to be searched for
	 * @return true, if array contains element.
	 */
	public static <T> boolean contains(T[] array, T needle) {
		return ArrayUtils.optionalIndexOf(array, needle).isPresent();
	}

	/**
	 * Maps an array to a new array.
	 *
	 * @param <T>    input array type
	 * @param <R>    mapped array type
	 * @param arr    the input array
	 * @param mapper the mapper to map array items
	 * @return new mapped array. input array is left intact.
	 */
	public static <T, R> R[] map(T[] arr, Function<T, R> mapper) {
		Assert.notNull(mapper, "Mapper must not be null.");

		if (arr == null) {
			return null;
		}

		R[] newArr = ArrayUtils.newArray(arr.length);
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = mapper.apply(arr[i]);
		}

		return newArr;
	}

	/**
	 * Returns a new, filtered array.
	 *
	 * @param <T>    input array type
	 * @param arr    input array
	 * @param filter filter predicate applied to each item
	 * @return filtered array. input array is left intact.
	 */
	public static <T> T[] filter(T[] arr, Predicate<T> filter) {
		Assert.notNull(filter, "Filter must not be null.");

		if (arr == null) {
			return null;
		}

		return Arrays.asList(arr).stream().filter(filter).toArray(ArrayUtils::newArray);
	}

	/**
	 * Join multiple arrays into a single one.
	 *
	 * @param <T>  array type
	 * @param arrs arrays to be joined
	 * @return joined array
	 */
	@SafeVarargs
	public static <T> T[] joinArrays(T[]... arrs) {
		if (arrs == null) {
			return null;
		}

		int length = 0;
		for (T[] arr : arrs) {
			length += arr.length;
		}

		T[] newArr = ArrayUtils.newArray(length);

		int offset = 0;
		for (T[] arr : arrs) {
			System.arraycopy(arr, 0, newArr, offset, arr.length);
			offset += arr.length;
		}

		return newArr;
	}

	/**
	 * Create a new array for a generic type.
	 *
	 * @param <R>    generic type
	 * @param length length of the new array
	 * @return new array
	 */
	@SuppressWarnings("unchecked")
	public static <R> R[] newArray(int length) {
		Object[] arr = new Object[length];
		return (R[]) arr;
	}

	private ArrayUtils() {
	}
}
