package com.intelliacademy.lesson.env;

import az.rock.csv4j.exception.CSVHeaderNotFoundException;
import az.rock.csv4j.exception.ElementManyAnnotatedException;
import az.rock.csv4j.manager.CSVManager;

import java.util.List;

public class DataProvider {
    public static List<Person> provide(){
        CSVManager<Person> csvManager;
        List<Person> personList;
        try {
            csvManager = new CSVManager<>(Person.class,"MOCK_DATA.csv");
            personList = csvManager.load();
        } catch (CSVHeaderNotFoundException | ElementManyAnnotatedException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }
}
