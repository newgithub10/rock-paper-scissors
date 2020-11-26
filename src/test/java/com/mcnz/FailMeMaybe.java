package com.mcnz;

import static org.junit.Assert.fail;
import org.junit.Assert;
import org.junit.Test;

public class FailMeMaybe {
	
	@Test
	public void testMyTrueAssertion() {
		//change true to false to fail the build
		Assert.assertTrue(true);
	}
	
}