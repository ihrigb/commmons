package de.ihrigb.commons;

import java.util.Collection;

public final class StringUtils {

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

	public static boolean hasText(String text) {
		if (text == null) {
			return false;
		}
		text = text.trim();
		return !"".equals(text);
	}

	private StringUtils() {
	}
}