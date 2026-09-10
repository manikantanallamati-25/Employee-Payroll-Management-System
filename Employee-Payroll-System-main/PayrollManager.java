import java.util.Scanner;

/**
 * PayrollManager Class - Manages payroll operations
 * Features: Generate payroll, Generate payslips
 */
public class PayrollManager {
    
    private EmployeeManager employeeManager;
    private Scanner scanner;
    
    // Constructor
    public PayrollManager(EmployeeManager employeeManager, Scanner scanner) {
        this.employeeManager = employeeManager;
        this.scanner = scanner;
    }
    
    // Generate payroll for an employee
    public void generatePayroll() {
        try {
            System.out.print("\nEnter Employee ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            
            Employee emp = employeeManager.searchEmployeeById(id);
            
            if (emp == null) {
                System.out.println("❌ Employee not found!");
                return;
            }
            
            Payroll payroll = new Payroll(emp);
            payroll.displayPayroll();
            
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid Employee ID!");
        }
    }
    
    // Generate payslip for an employee
    public void generatePayslip() {
        try {
            System.out.print("\nEnter Employee ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            
            Employee emp = employeeManager.searchEmployeeById(id);
            
            if (emp == null) {
                System.out.println("❌ Employee not found!");
                return;
            }
            
            Payroll payroll = new Payroll(emp);
            payroll.generatePayslip();
            
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid Employee ID!");
        }
    }
    
    // Display payroll for all employees
    public void displayAllPayrolls() {
        if (employeeManager.getEmployeeCount() == 0) {
            System.out.println("\n❌ No employees found!");
            return;
        }
        
        System.out.println("\n========================================");
        System.out.println("        ALL EMPLOYEES PAYROLL");
        System.out.println("========================================\n");
        
        Employee[] employees = employeeManager.getAllEmployees();
        for (int i = 0; i < employeeManager.getEmployeeCount(); i++) {
            Employee emp = employees[i];
            Payroll payroll = new Payroll(emp);
            payroll.displayPayroll();
        }
    }
}
