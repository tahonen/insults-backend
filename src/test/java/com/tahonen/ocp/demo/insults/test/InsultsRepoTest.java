package com.tahonen.ocp.demo.insults.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InsultsRepoTest {
	@Test
	public void getInsultTest(){
		String[] parts = new String[]{"1","2","3"};
		assertEquals("Correct amount of parts.", parts.length, 3);
	}
}
