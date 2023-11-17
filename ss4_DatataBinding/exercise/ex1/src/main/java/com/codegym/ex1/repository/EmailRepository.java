package com.codegym.ex1.repository;

import com.codegym.ex1.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailRepository implements IEmailRepository{
    private static final List<String> listLanguages = new ArrayList<>();
    private static final List<Integer> listPageSize = new ArrayList<>();
    static {
        listLanguages.add("English");
        listLanguages.add("Vietnamese");
        listLanguages.add("Japanese");
        listLanguages.add("Chinese");
        listPageSize.add(5);
        listPageSize.add(10);
        listPageSize.add(15);
        listPageSize.add(25);
        listPageSize.add(50);
        listPageSize.add(100);
    }
    @Override
    public List<String> getLanguages() {
        return listLanguages;
    }

    @Override
    public List<Integer> getPageSize() {
        return listPageSize;
    }

    @Override
    public Email getEmail() {
        Email email = new Email(listLanguages.get(0),listPageSize.get(5),false,"Thor, King,Asgard");
        return email;
    }
}
