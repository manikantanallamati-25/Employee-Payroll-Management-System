import java.util.Scanner;

/**
 * Main Class - Entry point for Employee Payroll System
 * Menu-driven console application
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager employeeManager = new EmployeeManager(scanner);
        PayrollManager payrollManager = new PayrollManager(employeeManager, scanner);
        
        boolean isRunning = true;
        
        while (isRunning) {
            displayMenu();
            
            try {
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        employeeManager.addEmployee();
                        break;
                    
                    case 2:
                        employeeManager.viewEmployees();
                        break;
                    
                    case 3:
                        employeeManager.searchEmployee();
                        break;
                    
                    case 4:
                        employeeManager.updateEmployee();
                        break;
                    
                    case 5:
                        employeeManager.deleteEmployee();
                        break;
                    
                    case 6:
                        payrollManager.generatePayroll();
                        break;
                    
                    case 7:
                        payrollManager.generatePayslip();
                        break;
                    
                    case 8:
                        System.out.println("\n👋 Thank you for using Employee Payroll System!");
                        isRunning = false;
                        break;
                    
                    default:
                        System.out.println("❌ Invalid choice! Please select 1-8.");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a number between 1-8.");
            }
        }
        
        scanner.close();
    }
    
    // Display main menu
    private static void displayMenu() {
        
        System.out.println("\n=================================");
        System.out.println("  EMPLOYEE PAYROLL SYSTEM");
        System.out.println("=================================");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Search Employee");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Generate Payroll");
        System.out.println("7. Generate Payslip");
        System.out.println("8. Exit");
        System.out.println("=================================");
    }
}
