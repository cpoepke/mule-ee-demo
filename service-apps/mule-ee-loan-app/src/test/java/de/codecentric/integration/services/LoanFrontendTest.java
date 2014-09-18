package de.codecentric.integration.services;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.api.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.tck.junit4.rule.DynamicPort;
import org.mule.tck.junit4.rule.SystemProperty;
import org.mule.util.FileUtils;

public class LoanFrontendTest extends FunctionalTestCase {

    @Rule
    public DynamicPort port = new DynamicPort("app.port");

    @Rule
    public SystemProperty home = new SystemProperty("app.home", new File("src/main/app").getAbsolutePath());

    @Test
    public void testGetIndexHtml() throws Exception {
        MuleClient client = muleContext.getClient();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("http.method", "GET");
        MuleMessage reply = client.send("http://localhost:" + port.getNumber(), null, map, 5000);

        assertNotNull(reply);
        assertNotNull(reply.getPayload());
        assertEquals(FileUtils.readFileToString(new File(home.getValue() + "/web/index.html")), reply.getPayloadAsString());
    }

    protected String getConfigFile() {
        return "mule-config.xml";
    }
}
