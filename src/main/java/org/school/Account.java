package org.school;

public class Account {
    private static String login;
    private static String password;
    private static String name;
    private static String surname;
    private static Integer idLecturer;

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        Account.login = login;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Account.password = password;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Account.name = name;
    }

    public static String getSurname() {
        return surname;
    }

    public static void setSurname(String surname) {
        Account.surname = surname;
    }

    public static void setIdLecturer(Integer s) {
        idLecturer = s;
    }

    public static Integer getIdLecturer() {
        return idLecturer;
    }
}
