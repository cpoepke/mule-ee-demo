package de.codecentric.integration.component;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.google.common.collect.Maps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@RunWith(JUnit4.class)
public class ScoringComponentTest {

	@Test
	public void testScoring() throws ParseException {
		Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("name", "Max Mustermann");
        dataMap.put("email", "max@mustermann.de");
        dataMap.put("birthday", new SimpleDateFormat("dd.MM.yyyy").parse("01.01.1980"));

        Map<String, Object> returnMap = new ScoringComponent().scoreCustomer(dataMap);

        assertNotNull(returnMap);
		Long result = (Long) returnMap.get("scoring");
		assertTrue(result.intValue() >= 34);
	}
}
