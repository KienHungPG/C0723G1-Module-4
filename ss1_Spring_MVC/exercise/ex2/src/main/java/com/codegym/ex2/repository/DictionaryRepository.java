package com.codegym.ex2.repository;

import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository{
    private static final Map<String, String> stringMap = new LinkedHashMap<>();
    static {
        stringMap.put("dog","con chó");
        stringMap.put("mouse","con chuột");
        stringMap.put("cat","con mèo");
        stringMap.put("elephant","con voi");
        stringMap.put("raccoon","gấu mèo");
        stringMap.put("monkey","con khỉ");
    }
    @Override
    public Map<String, String> getDictionary() {
        return stringMap;
    }
}
