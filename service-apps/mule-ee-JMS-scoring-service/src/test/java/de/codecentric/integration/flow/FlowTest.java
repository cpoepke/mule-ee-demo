package de.codecentric.integration.flow;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class FlowTest extends FunctionalTestCase {

	@Test
	public void testScoring() throws Exception{
		MuleClient client = muleContext.getClient();
		Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("name", "Max Mustermann");
        dataMap.put("email", "max@mustermann.de");
        dataMap.put("birthday", new SimpleDateFormat("dd.MM.yyyy").parse("01.01.1980"));

		MuleMessage reply = client.send ("jms://ScoringQueue", dataMap, null, 5000);
		
		assertNotNull(reply);
		assertNotNull(reply.getPayload());
		assertTrue(reply.getPayload() instanceof HashMap);
		@SuppressWarnings("unchecked")
		Long result = (Long) ((HashMap<String, Object>) reply.getPayload()).get("scoring");
		assertTrue(result.intValue() >= 34);
	}
	
	protected String getConfigFile() {
		return "./src/main/app/mule-config.xml";
	}
}
