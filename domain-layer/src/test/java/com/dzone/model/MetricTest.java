package com.dzone.model;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Method;

import static org.junit.Assert.assertEquals;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class MetricTest {

    @Test
    public void boilerPlate() {
        Class<Metric> clazzMetric = Metric.class;
        assertPojoMethodsFor(clazzMetric).testing(Method.GETTER, Method.SETTER, Method.TO_STRING, Method.EQUALS, Method.HASH_CODE)
                .areWellImplemented();
    }

    @Test
    public void testMetricBuilder(){
        Metric metric1 = Metric.builder().id(1L).result(Boolean.TRUE).build();
        Metric metric2 = Metric.builder().id(1L).result(Boolean.TRUE).build();
        assertEquals(metric1, metric2);
        assertEquals(Metric.builder().toString(), Metric.builder().toString());
    }

}
