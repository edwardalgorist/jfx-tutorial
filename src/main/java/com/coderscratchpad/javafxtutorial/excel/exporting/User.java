package com.coderscratchpad.javafxtutorial.excel.exporting;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/exporting-javafx-table-data-to-excel/">coderscratchpad.com</a>
 */
public record User(int id, String name, int age, String gender, String language, String country) {

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }
}