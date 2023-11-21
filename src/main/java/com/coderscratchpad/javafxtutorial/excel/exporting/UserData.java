package com.coderscratchpad.javafxtutorial.excel.exporting;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/exporting-javafx-table-data-to-excel/">coderscratchpad.com</a>
 */
public class UserData {

    public static ObservableList<User> getUsers() {

        ObservableList<User> userList = FXCollections.observableArrayList();

        // Add 20 dummy user data
        userList.add(new User(1, "Alice", 25, "Female", "English", "USA"));
        userList.add(new User(2, "Bob", 30, "Male", "Spanish", "Spain"));
        userList.add(new User(3, "Charlie", 22, "Male", "French", "France"));
        userList.add(new User(4, "David", 28, "Male", "German", "Germany"));
        userList.add(new User(5, "Eve", 33, "Female", "Italian", "Italy"));
        userList.add(new User(6, "Frank", 29, "Male", "Dutch", "Netherlands"));
        userList.add(new User(7, "Grace", 27, "Female", "Japanese", "Japan"));
        userList.add(new User(8, "Hannah", 24, "Female", "Korean", "South Korea"));
        userList.add(new User(9, "Ivan", 35, "Male", "Russian", "Russia"));
        userList.add(new User(10, "Jasmine", 23, "Female", "Arabic", "UAE"));
        userList.add(new User(11, "Kevin", 31, "Male", "Chinese", "China"));
        userList.add(new User(12, "Lily", 26, "Female", "Portuguese", "Portugal"));
        userList.add(new User(13, "Michael", 32, "Male", "Swedish", "Sweden"));
        userList.add(new User(14, "Nora", 21, "Female", "Danish", "Denmark"));
        userList.add(new User(15, "Oliver", 34, "Male", "Greek", "Greece"));
        userList.add(new User(16, "Penny", 28, "Female", "Turkish", "Turkey"));
        userList.add(new User(17, "Quincy", 29, "Male", "Finnish", "Finland"));
        userList.add(new User(18, "Rachel", 25, "Female", "Norwegian", "Norway"));
        userList.add(new User(19, "Sam", 27, "Male", "Polish", "Poland"));
        userList.add(new User(20, "Tina", 26, "Female", "Hungarian", "Hungary"));

        return userList;
    }
}
