package Lesson3;

import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String surname, String number) {
        List<String> numbers = phoneBook.getOrDefault(surname, new ArrayList<>());
        numbers.add(number);
        phoneBook.put(surname, numbers);
    }

    public List<String> get(String surname) {
        return phoneBook.get(surname);
    }
}
