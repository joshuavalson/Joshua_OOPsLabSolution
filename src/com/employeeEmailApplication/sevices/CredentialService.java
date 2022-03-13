package com.employeeEmailApplication.sevices;

import com.employeeEmailApplication.model.employee;
import java.util.Random;

public class CredentialService {

    public static String GreatLearning = ".GreatLearning.com";

    private String email;
    private String password;

    ///generate random password of length 8
    public void generatePassword() {

        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        char[] _password = new char[8];

        _password[0] = lowerCaseLetters.charAt((int)(Math.random() * lowerCaseLetters.length()));
        _password[1] = capitalCaseLetters.charAt((int)(Math.random() * capitalCaseLetters.length()));
        _password[2] = specialCharacters.charAt((int)(Math.random() * specialCharacters.length()));
        _password[3] = numbers.charAt((int)(Math.random() * numbers.length()));
        _password[4] = lowerCaseLetters.charAt((int)(Math.random() * lowerCaseLetters.length()));
        _password[5] = capitalCaseLetters.charAt((int)(Math.random() * capitalCaseLetters.length()));
        _password[6] = specialCharacters.charAt((int)(Math.random() * specialCharacters.length()));
        _password[7] = numbers.charAt((int)(Math.random() * numbers.length()));


        this.password = String.copyValueOf(_password);
    }

    public void generateEmailAddress(String department, employee employee) {
        this.email = employee.getFirstName() + employee.getLastName() + "@" + department + GreatLearning;
    }

    public void showCredentials(employee employee) {
        System.out.println("Dear " + employee.getFirstName() +" your generated credentials are as follows");
        System.out.println("\n Email     ------> " + this.email);
        System.out.println("\n Password  ------> " + this.password);
    }

}
