package de.ihrigb.commons;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecimalPowersTest {

	@Test
	public void test() throws Exception {
		DecimalPowers kilo = DecimalPowers.KILO;
		Assertions.assertAll(() -> Assertions.assertEquals(3, kilo.getDecimalPower()),
				() -> Assertions.assertEquals(1000d, kilo.getFactor(), 0.0000001d),
				() -> Assertions.assertEquals(5000d, kilo.multiply(5), 0.0000001d),
				() -> Assertions.assertEquals(0.005d, kilo.divide(5), 0.0000001d));
	}
}
