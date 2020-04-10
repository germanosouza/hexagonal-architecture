package com.dzone.adapter;

import com.dzone.service.IAnagramServicePort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AnagramsControllerTest {

    private static final String URL_PREFIX = "/anagrams/";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IAnagramServicePort anagramService;

    @Test
    public void whenWordsAreAnagrams_thenIsOK() throws Exception {
        String url = URL_PREFIX + "/Hello/hello";
        given(anagramService.isAnagram(anyString(), anyString())).willReturn(true);
        this.mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"areAnagrams\":true}")));
    }

    @Test
    public void whenWordsAreNotAnagrams_thenIsOK() throws Exception {
        String url = URL_PREFIX + "/HelloDAD/HelloMOM";
        given(anagramService.isAnagram(anyString(), anyString())).willReturn(false);
        this.mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"areAnagrams\":false}")));
    }

}