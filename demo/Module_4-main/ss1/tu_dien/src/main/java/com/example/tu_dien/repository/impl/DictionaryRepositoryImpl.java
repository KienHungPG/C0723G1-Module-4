package com.example.tu_dien.repository.impl;

import com.example.tu_dien.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class DictionaryRepositoryImpl implements IDictionaryRepository {
    private static Map<String, String> stringMap = new LinkedHashMap<>();

    static {
        stringMap.put("learn", "Học");
        stringMap.put("head phone", "Tai nghe");
        stringMap.put("computer", "Máy tính");
        stringMap.put("mouse", "Chuột");
        stringMap.put("pig", "Heo");
    }

    @Override
    public Map<String, String> getDictionary() {
        return stringMap;
    }

}
