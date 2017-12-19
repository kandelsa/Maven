/**
 * 
 */
package com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * @author KANDEL Sarah
 *
 */
public class AdditionTest extends TestCase {

	Addition add = new Addition();
	
	@Before
	@After
	
	@Test
	public void additionAvecDeuxNombres() {
		final long lAddition = add.calculer(2L,3L);
		Assert.assertEquals(6L, lAddition);
	}
	
	@Test
	public void lireSymboleTest() {
		final long lAddition = add.lireSymbole();
		Assert.assertEquals('-', lAddition);
	}
}
