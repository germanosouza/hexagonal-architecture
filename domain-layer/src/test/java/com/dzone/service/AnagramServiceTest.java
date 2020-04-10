package com.dzone.service;

import com.dzone.service.AnagramService;
import com.dzone.service.IAnagramMetricPort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AnagramServiceTest {

    @Mock
    private IAnagramMetricPort metricPort;
    @InjectMocks
    private AnagramService anagramService;

    @Test
    public void whenWordsAreAnagrams_thenIsOK() {
        boolean isAnagram = anagramService.isAnagram("Hello", "hello");
        assertTrue(isAnagram);
    }

    @Test
    public void whenWordsAreNotAnagrams_thenIsOK() {
        boolean isAnagram = anagramService.isAnagram("HelloDAD", "HelloMOM");
        assertFalse(isAnagram);
    }

    @Test
    public void whenWordsAreDifferentInSize_thenIsOK() {
        boolean isAnagram = anagramService.isAnagram("asdfasfasdfasdf", "22");
        assertFalse(isAnagram);
    }
}
