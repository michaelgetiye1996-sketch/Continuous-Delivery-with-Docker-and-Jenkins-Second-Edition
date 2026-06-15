package com.leszko.calculator;

import com.hazelcast.client.config.ClientConfig;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculatorControllerTest {

    @Test
    public void testSumEndpoint() throws Exception {
        CalculatorController controller = new CalculatorController();

        Field calculatorField = CalculatorController.class.getDeclaredField("calculator");
        calculatorField.setAccessible(true);
        calculatorField.set(controller, new Calculator());

        assertEquals("5", controller.sum(2, 3));
    }

    @Test
    public void testHazelcastClientConfig() {
        CalculatorApplication application = new CalculatorApplication();
        ClientConfig config = application.hazelcastClientConfig();
        assertNotNull(config);
    }
}
