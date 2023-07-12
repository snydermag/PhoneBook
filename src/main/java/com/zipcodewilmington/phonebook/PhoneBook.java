package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new TreeMap<>());

    }

    public void add(String name, String phoneNumber) {
        if (phonebook.containsKey(name)){
            phonebook.get(name).add(phoneNumber);
        }
        else {
            phonebook.put(name, new ArrayList<>());
            phonebook.get(name).add(phoneNumber);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        for (String n : phoneNumbers) {
            add(name, n);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name, String number) {
        if (phonebook.containsKey(name) && phonebook.get(name).contains(number)){
            return true;
        }
        return false;
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (String key : phonebook.keySet()){
            if (phonebook.get(key).contains(phoneNumber)){
                return key;
            }

        }
        return null;
    }

    public List<String> getAllContactNames() {
        return null;
    }

    public Map<String, List<String>> getMap() {
        return new HashMap(phonebook);
    }
}
