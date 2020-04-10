package com.dzone.service;

import com.dzone.model.Metric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnagramService implements IAnagramServicePort {

    @Autowired
    private IAnagramMetricPort metricPort;

    @Override
    public boolean isAnagram(String firstWord, String secondWord) {
        String s1 = firstWord.replaceAll("\\s", "");
        String s2 = secondWord.replaceAll("\\s", "");
        boolean status = true;
        if (s1.length() != s2.length()) {
            status = false;
        } else {
            char[] ArrayS1 = s1.toLowerCase().toCharArray();
            char[] ArrayS2 = s2.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        saveMetric(status);
        return status;
    }

    private void saveMetric(final boolean result) {
        metricPort.save(Metric.builder().result(result).build());
    }
}
