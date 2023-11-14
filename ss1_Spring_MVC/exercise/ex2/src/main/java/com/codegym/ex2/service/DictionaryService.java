package com.codegym.ex2.service;

import com.codegym.ex2.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService{
    @Autowired
    private IDictionaryRepository dictionaryRepository;
    @Override
    public String getDictionary(String text) {
        String result = null;
        Map<String, String> stringMap = dictionaryRepository.getDictionary();
        for (String m : stringMap.keySet()) {
            if (text.toLowerCase(Locale.ROOT).equals(m)){
                result = stringMap.get(m);
                break;
            }else {
                result = "Not found in the dicionary";
            }
        }
        if (text.trim().equals("")){
            result = "Please enter the word you want to look up!!!";
        }
        return result;
    }
}
