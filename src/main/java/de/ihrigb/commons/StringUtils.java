package de.ihrigb.commons;

import java.util.Collection;

/**
 * Utils to handle strings.
 */
public final class StringUtils {

	/**
	 * Checks if a collection of strings contains a certain value, ignoring case.
	 *
	 * @param col    collection to be checked
	 * @param needle needle to be searched ignoring case
	 * @return true, if case-ignored needle is contained; also returns true, if
	 *         needle is null and collection contains null
	 */
	public static boolean containsIgnoreCase(Collection<String> col, String needle) {
		if (col == null) {
			return false;
		}

		for (String str : col) {
			if (needle == null && str == null) {
				return true;
			}
			if (needle != null && needle.equalsIgnoreCase(str)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Check if a string contains any characters and is not empty after default
	 * trim. Null is considered false.
	 *
	 * @param text text to be checked
	 * @return if contains any characters that are not blank.
	 */
	public static boolean hasText(String text) {
		if (text == null) {
			return false;
		}
		text = text.trim();
		return !"".equals(text);
	}

	/**
	 * Concats multiple strings.
	 *
	 * @param strings strings to be concatenated.
	 * @return concatenated string
	 */
	public static String concat(String... strings) {
		if (strings == null) {
			return null;
		}

		String res = "";
		for (String s : strings) {
			res += s;
		}
		return res;
	}

	/**
	 * Merges multiple strings with a delimiter.
	 *
	 * @param delim   delimiter
	 * @param strings strings to be merged around a delimiter
	 * @return merged string
	 */
	public static String merge(String delim, String... strings) {
		if (delim == null) {
			return StringUtils.concat(strings);
		}

		if (strings == null) {
			return null;
		}

		String res = "";
		for (int i = 0; i < strings.length; i++) {
			res = StringUtils.concat(res, strings[i]);
			if (i < strings.length - 1) {
				res = StringUtils.concat(res, delim);
			}
		}
		return res;
	}

	private StringUtils() {
	}
}
