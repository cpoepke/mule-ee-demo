package de.codecentric.integration.component;

import org.joda.time.DateTime;
import org.joda.time.Years;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ScoringComponent {

	public Map<String, Object> scoreCustomer(Map<String, Object> dataMap) {
		if (!dataMap.containsKey("birthday")) {
			return Collections.emptyMap();
		}
		
		long years = Years.yearsBetween(new DateTime(dataMap.get("birthday")), new DateTime()).getYears();

		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("name", dataMap.get("name"));
		returnMap.put("scoring", years);
		return returnMap;
	}
}
