package com.dzone.adapter;

import com.dzone.service.IAnagramServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleAnagramAdaptor {

    @Autowired
    private IAnagramServicePort anagramService;

    public boolean isAnagram(String firstWord, String secondWord) {
        return anagramService.isAnagram(firstWord, secondWord);
    }
}
