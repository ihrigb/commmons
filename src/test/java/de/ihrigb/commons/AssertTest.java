package de.ihrigb.commons;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertTest {

	@Test
	public void test() throws Exception {
		Assertions.assertAll(
				() -> Assertions.assertThrows(IllegalArgumentException.class, () -> Assert.notNull(null, "message")),
				() -> Assertions.assertDoesNotThrow(() -> Assert.notNull("data", "message")),
				() -> Assertions.assertThrows(IllegalArgumentException.class,
						() -> Assert.notNull(null, () -> new IllegalArgumentException())),
				() -> Assertions
						.assertDoesNotThrow(() -> Assert.notNull("data", () -> new IllegalArgumentException())));
	}
}
