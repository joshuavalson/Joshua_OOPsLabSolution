package com.employeeEmailApplication.controller;
import java.io.IOException;
import java.util.Scanner;
import com.employeeEmailApplication.model.employee;
import com.employeeEmailApplication.sevices.CredentialService;

public class employeeEmailApplication{
    
    public static void main(String[] args) {
        
        int choice = Integer.MAX_VALUE;
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        employee employee;

        do{
            System.out.println("\n Please enter Employee First Name :");
            String fname = scanner.nextLine();
            System.out.println("\n Please enter Employee Last Name :");
            String lname = scanner.nextLine();

            employee = new employee(fname, lname);

            if(!employee.getFirstName().isEmpty() && !employee.getLastName().isEmpty())
            {
                System.out.println("\n Hello "+fname+" Welcome to Employee Email Generator !!");
                flag=false;
            }
            else{
                System.out.println("\n Invalid values. Please try again!");
                flag=true;
            }
        } while(flag);
        flag = true;

        do {
            System.out.println("\n Please enter your Department :");
            System.out.println("\n 1. Technical ");
            System.out.println("\n 2. Admin ");
            System.out.println("\n 3. Human Resource ");
            System.out.println("\n 4. Legal ");
            System.out.println("\n 5. Logout ");
            System.out.println("\n Option :");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1: //Tech                    
                    generator("Technical", employee);
                    break;
                case 2: //Admin
                    generator("Admin", employee);
                    break;
                case 3: //HR
                    generator("HumanResource", employee);            
                    break;
                case 4: //Legal
                    generator("Legal", employee);           
                    break;
                case 5: //logout
                    System.out.println("\n Thank you for using the email generator!");
                    flag = false;
                    break;
                default:
                    System.out.println("\n Invalid Choice. Please select valid one!");
                    break;
            }

        } while (flag);

        scanner.close();
    }

    

    private static void generator(String department, employee employee)
    {
        CredentialService credentialService = new CredentialService();
        credentialService.generateEmailAddress(department, employee);
        credentialService.generatePassword();
        credentialService.showCredentials(employee);
    }
}