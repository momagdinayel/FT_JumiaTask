package org.example.Utils;

import com.github.javafaker.Faker;

public class FakerUtils {
    public static String generateName(){
        Faker faker = new Faker();
        return faker.regexify("[A-Za-z0-9]{10}");
    }
    public static int generateNumber(){
        Faker faker = new Faker();
        return faker.number().numberBetween(1111,9999);
    }
    public static String generateDescription(){
        Faker faker = new Faker();
        return "Description " + faker.regexify("[ A-Za-z0-9_@./#&+-]{50}");
    }
}
