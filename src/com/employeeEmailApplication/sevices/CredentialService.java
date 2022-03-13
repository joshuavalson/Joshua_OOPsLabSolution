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
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[8];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for (int i = 4; i < 8; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }

        this.password = password.toString();
    }

    public void generateEmailAddress(String department, employee employee) {
        this.email = employee.getFirstName() + employee.getLastName() + "@" + department + GreatLearning;
    }

    public void showCredentials() {
        System.out.println("\n Email     ------> " + this.email);
        System.out.println("\n Password  ------> " + this.password);
    }

}
