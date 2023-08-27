package com.intelliacademy.lesson.env;

import java.time.LocalDate;
import java.util.Random;

public class Person {
    private final String name;
    private final String firstName;
    private final Integer age;
    private final LocalDate birthDay;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    private Person(Builder builder) {
        name = builder.name;
        firstName = builder.firstName;
        age = builder.age;
        birthDay = builder.birthDay;
    }

    public static class Prototype {
        private static final Random RANDOM = new Random();
        private static String[] nameValues = new String[]{"Vugar","Kamil","Elcin","Anar","Xeqani"};
        private static String[] lastNameValues = new String[]{"Mammadli","Rustemli","Semedov","Sixlenski","Eliyev"};


        public static Person random(){
            var indexName = RANDOM.nextInt(5);
            var indexLastName = RANDOM.nextInt(5);
            var currentYear = LocalDate.now();
            var age = RANDOM.nextInt(100);
            return Builder
                    .builder()
                    .name(nameValues[indexName])
                    .firstName(lastNameValues[indexLastName])
                    .age(age)
                    .birthDay(currentYear.minusYears(age))
                    .build();
        }
    }

    public static final class Builder {
        private String name;
        private String firstName;
        private Integer age;
        private LocalDate birthDay;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Builder birthDay(LocalDate val) {
            birthDay = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
