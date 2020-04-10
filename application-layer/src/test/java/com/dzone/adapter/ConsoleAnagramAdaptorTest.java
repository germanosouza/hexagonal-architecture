package com.dzone.adapter;

import com.dzone.service.IAnagramServicePort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleAnagramAdaptorTest {

    @Mock
    private IAnagramServicePort anagramService;

    @InjectMocks
    private ConsoleAnagramAdaptor consoleAnagramAdaptor;

    @Test
    public void whenWordsAreAnagrams_thenIsOK() {
        given(anagramService.isAnagram(anyString(), anyString())).willReturn(true);
        boolean isAnagram = consoleAnagramAdaptor.isAnagram("Hello", "hello");
        assertTrue(isAnagram);
    }

    @Test
    public void whenWordsAreNotAnagrams_thenIsOK() {
        given(anagramService.isAnagram(anyString(), anyString())).willReturn(false);
        boolean isAnagram = consoleAnagramAdaptor.isAnagram("HelloDAD", "HelloMOM");
        assertFalse(isAnagram);
    }
}
