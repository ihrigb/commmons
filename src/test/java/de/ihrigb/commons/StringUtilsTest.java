package de.ihrigb.commons;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

	@Test
	public void testContainsIgnoreCaseNullCollection() throws Exception {
		Assertions.assertFalse(StringUtils.containsIgnoreCase(null, null), "containsIgnoreCase should return false.");
	}

	@Test
	public void testContainsIgnoreCaseContainsNullNeedle() throws Exception {
		Assertions.assertTrue(StringUtils.containsIgnoreCase(Arrays.asList("value", null), null),
				"containsIgnoreCase should return true.");
	}

	@Test
	public void testContainsIgnoreCaseNotContainsNullNeedle() throws Exception {
		Assertions.assertFalse(StringUtils.containsIgnoreCase(Arrays.asList("value1", "value2"), null),
				"containsIgnoreCase should return true.");
	}

	@Test
	public void testContainsIgnoreCaseContainsStringNeedle() throws Exception {
		Assertions.assertTrue(StringUtils.containsIgnoreCase(Arrays.asList("value1", "value2"), "value2"),
				"containsIgnoreCase should return true.");
	}

	@Test
	public void testContainsIgnoreCaseNotContainsStringNeedle() throws Exception {
		Assertions.assertFalse(StringUtils.containsIgnoreCase(Arrays.asList("value1", "value2"), "value3"),
				"containsIgnoreCase should return true.");
	}
}
