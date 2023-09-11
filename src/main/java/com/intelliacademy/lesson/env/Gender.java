package com.intelliacademy.lesson.env;

public enum Gender {
    MALE,FEMALE,UNDEFINED;

    public static Gender of(String value){
        try {
            return  Enum.valueOf(Gender.class,value.toUpperCase());
        }catch (IllegalArgumentException e){
            return UNDEFINED;
        }
    }
}
