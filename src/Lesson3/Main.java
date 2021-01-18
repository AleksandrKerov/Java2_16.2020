package Lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] animals = {"cat", "dog", "cat", "cow", "cat", "chicken",
                "horse", "cat", "pig", "dog", "rabbit",
                "lamb", "donkey", "dog", "sheep"};

        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(animals).forEach(animal -> {
            Integer val = map.getOrDefault(animal, 0);
            map.put(animal, val + 1);
        });
        System.out.println(map);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Black", "+7(911)111-11-11");
        phoneBook.add("White", "+7(911)222-11-11");
        phoneBook.add("Smith", "+7(911)222-11-33");
        phoneBook.add("Jones", "+7(911)422-11-34");
        phoneBook.add("Williams", "+7(911)422-55-34");
        phoneBook.add("Williams", "+7(911)422-66-34");
        phoneBook.add("Williams", "+7(911)422-77-34");

        System.out.println(phoneBook.get("Black"));
        System.out.println(phoneBook.get("White"));
        System.out.println(phoneBook.get("Williams"));
    }
}

