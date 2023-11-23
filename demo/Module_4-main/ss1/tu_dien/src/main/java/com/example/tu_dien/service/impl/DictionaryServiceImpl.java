package com.example.tu_dien.service.impl;

import com.example.tu_dien.repository.impl.DictionaryRepositoryImpl;
import com.example.tu_dien.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Autowired
    private DictionaryRepositoryImpl dictionaryRepository;

    @Override
    public String getDictionary(String text) {
        String result = null;
        Map<String, String> stringMap = dictionaryRepository.getDictionary();
        for (String m : stringMap.keySet()) {
            if (text.toLowerCase(Locale.ROOT).equals(m)) {
                result = stringMap.get(m);
                break;
            } else {
                result = "Từ điển không có từ này";
            }
        }
        if (text.equals("")) {
            result = "Mời bạn nhập từ";
        }
        return result;
    }
}
