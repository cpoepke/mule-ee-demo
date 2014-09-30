package de.codecentric.integration.flow;

import static org.junit.Assert.*;

import com.google.common.collect.Maps;
import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.munit.runner.functional.FunctionalMunitSuite;

import java.util.HashMap;
import java.util.Map;

public class CreditCheckFlowTest extends FunctionalMunitSuite {

    private static String TEST_JSON = "{\n" +
            "  \"name\": \"Max Mustermann\",\n" +
            "  \"street\": \"Coffee street\",\n" +
            "  \"area_code\": 12345,\n" +
            "  \"city\": \"Coffee city\",\n" +
            "  \"house_number\": 12,\n" +
            "  \"email\": \"max@mustermann.de\",\n" +
            "  \"birthday\": \"01.01.1980\"\n" +
            "}";

	@Test
	public void testCreditCheckFlow() throws Exception {

        Map<String, Object> mockMap = Maps.newHashMap();
        mockMap.put("name", "Max Mustermann");
        mockMap.put("scoring", 30l);
		whenEndpointWithAddress("jms://ScoringQueue").thenReturn(muleMessageWithPayload(mockMap));

        MuleMessage resultMsg = runFlow("credit-check-service-flow", testEvent(TEST_JSON)).getMessage();

		assertNotNull(resultMsg);
		assertNotNull(resultMsg);
		assertTrue(resultMsg.getPayload() instanceof HashMap);
		@SuppressWarnings("unchecked")
		Long result = (Long) ((HashMap<String, Object>) resultMsg.getPayload()).get("scoring");
		assertTrue(result.intValue() == 30);
	}
}
