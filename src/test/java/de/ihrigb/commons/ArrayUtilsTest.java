package de.ihrigb.commons;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTest {

	@Test
	public void testContainsTrue() throws Exception {
		Assertions.assertTrue(ArrayUtils.contains(new String[] { "value1", "value2" }, "value2"),
				"ArrayUtils.contains() should return true.");
	}

	@Test
	public void testContainsFalse() throws Exception {
		Assertions.assertFalse(ArrayUtils.contains(new String[] { "value1", "value2" }, "value3"),
				"ArrayUtils.contains() should return false.");
	}

	@Test
	public void testIndexOfArrayNull() throws Exception {
		Assertions.assertEquals(-1, ArrayUtils.indexOf(null, null), "indexOf should return -1");
	}

	@Test
	public void testIndexOfEmptyArray() throws Exception {
		Assertions.assertEquals(-1, ArrayUtils.indexOf(new String[0], null), "indexOf should return -1");
	}

	@Test
	public void testIndexOfNullNeedleMissing() throws Exception {
		Assertions.assertEquals(-1, ArrayUtils.indexOf(new String[] { "value" }, null), "indexOf should return -1");
	}

	@Test
	public void testIndexOfNullNeedleFound1() throws Exception {
		Assertions.assertEquals(0, ArrayUtils.indexOf(new String[] { null, "value" }, null), "indexOf should return 0");
	}

	@Test
	public void testIndexOfNullNeedleFound2() throws Exception {
		Assertions.assertEquals(1, ArrayUtils.indexOf(new String[] { "value", null }, null), "indexOf should return 1");
	}

	@Test
	public void testIndexOfNullNeedleNotFound() throws Exception {
		Assertions.assertEquals(-1, ArrayUtils.indexOf(new String[] { "value1", "value2" }, "value3"),
				"indexOf should return -1");
	}
}
