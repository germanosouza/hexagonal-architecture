package com.dzone.adapter;

import com.dzone.service.IAnagramServicePort;
import com.dzone.dto.AnagramDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class AnagramsController {

    @Autowired
    private IAnagramServicePort anagramService;

    @GetMapping("anagrams/{firstWord}/{secondWord}")
    public ResponseEntity<AnagramDTO> verifyAnagram(@Valid @PathVariable String firstWord, @Valid @PathVariable String secondWord) {
        boolean isAnagram = anagramService.isAnagram(firstWord, secondWord);
        return new ResponseEntity<>(new AnagramDTO(isAnagram), HttpStatus.OK);
    }
}
