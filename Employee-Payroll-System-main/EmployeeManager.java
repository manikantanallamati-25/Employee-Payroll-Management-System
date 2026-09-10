import java.util.Scanner;

/**
 * EmployeeManager Class - Manages employee operations
 * Features: Add, View, Search, Update, Delete employees
 */
public class EmployeeManager extends Employee {
    
    //private static final int INITIAL_CAPACITY = 10;

   

    private Employee[] employees;
    private int employeeCount;
    private Scanner scanner;
    private int nextEmployeeId;
    
    // Constructor
        public EmployeeManager(int id, String name, 
        String department, String designation, double basicSalary) {
        super(id, name, department, designation, basicSalary);
    this.employees = new Employee[10];
        this.employeeCount = 0;
        this.nextEmployeeId = 1;
    }

    // Add a new employee
    public void addEmployee() {
        try {
            System.out.print("\nEnter Employee Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Department: ");
            String department = scanner.nextLine();
            
            System.out.print("Enter Designation: ");
            String designation = scanner.nextLine();
            
            System.out.print("Enter Basic Salary: ");
            double basicSalary = Double.parseDouble(scanner.nextLine());
            
            if (basicSalary <= 0) {
                System.out.println("❌ Salary must be positive!");
                return;
            }
            
            int empId = nextEmployeeId++;
            Employee emp = new Employee(empId, name, department, designation, basicSalary);
            //ensureCapacity();
            employees[employeeCount++] = emp;
            
            System.out.println("✓ Employee added successfully! ID: " + empId);
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input! Please enter valid data.");
        }
    }
    
    // View all employees
    public void viewEmployees() {
        if (employeeCount == 0) {
            System.out.println("\n❌ No employees found!");
            return;
        }
        System.out.println("\n=============================================");
        System.out.println("              EMPLOYEE LIST");
        System.out.println("=============================================");
        System.out.printf("%-6s %-15s %-15s %-15s %-10s\n", "ID", "Name", "Department", "Designation", "Salary");
        System.out.println("---------------------------------------------");
        
        for (int i = 0; i < employeeCount; i++) {
            Employee emp = employees[i];
            System.out.printf("%-6d %-15s %-15s %-15s %-10.2f\n", 
                emp.getId(), emp.getName(), emp.getDepartment(), 
                emp.getDesignation(), emp.getBasicSalary());
        }
        System.out.println("=============================================\n");
    }
    
    // Search employee by ID
    public Employee searchEmployeeById(int id) {
        for (int i = 0; i < employeeCount; i++) {
            Employee emp = employees[i];
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
    
    // Display single employee details
    public void searchEmployee() {
        try {
            System.out.print("\nEnter Employee ID to search: ");
            int id = Integer.parseInt(scanner.nextLine());
            
            Employee emp = searchEmployeeById(id);
            
            if (emp != null) {
                System.out.println("\n✓ Employee Found!");
                System.out.println("ID          : " + emp.getId());
                System.out.println("Name        : " + emp.getName());
                System.out.println("Department  : " + emp.getDepartment());
                System.out.println("Designation : " + emp.getDesignation());
                System.out.println("Salary      : ₹" + String.format("%.2f", emp.getBasicSalary()));
            } else {
                System.out.println("❌ Employee not found!");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid Employee ID!");
        }
    }
    
    // Update employee information
    public void updateEmployee() {
        try {
            System.out.print("\nEnter Employee ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());
            
            Employee emp = searchEmployeeById(id);
            
            if (emp == null) {
                System.out.println("❌ Employee not found!");
                return;
            }
            
            System.out.print("Enter new name (current: " + emp.getName() + "): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                emp.setName(name);
            }
            
            System.out.print("Enter new department (current: " + emp.getDepartment() + "): ");
            String department = scanner.nextLine();
            if (!department.isEmpty()) {
                emp.setDepartment(department);
            }
            
            System.out.print("Enter new designation (current: " + emp.getDesignation() + "): ");
            String designation = scanner.nextLine();
            if (!designation.isEmpty()) {
                emp.setDesignation(designation);
            }
            
            System.out.print("Enter new salary (current: " + emp.getBasicSalary() + "): ");
            String salaryInput = scanner.nextLine();
            if (!salaryInput.isEmpty()) {
                double salary = Double.parseDouble(salaryInput);
                emp.setBasicSalary(salary);
            }
            
            System.out.println("✓ Employee updated successfully!");
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input!");
        }
    }
    
    // Delete employee
    public void deleteEmployee() {
        try {
            System.out.print("\nEnter Employee ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());
            
            Employee emp = searchEmployeeById(id);
            
            if (emp == null) {
                System.out.println("❌ Employee not found!");
                return;
            }
            
            System.out.print("Are you sure? (Y/N): ");
            String confirmation = scanner.nextLine();
            
            if (confirmation.equalsIgnoreCase("Y")) {
                removeEmployee(emp);
                System.out.println("✓ Employee deleted successfully!");
            } else {
                System.out.println("❌ Operation cancelled!");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid Employee ID!");
        }
    }
    
    // Get all employees
    public Employee[] getAllEmployees() {
        return employees;
    }

    // Get the number of employee records currently stored
    public int getEmployeeCount() {
        return employeeCount;
    }

    // Expand the array when it is full
    private void ensureCapacity() {
        if (employeeCount == employees.length) {
            Employee[] expandedEmployees = new Employee[employees.length * 2];
            for (int i = 0; i < employees.length; i++) {
                expandedEmployees[i] = employees[i];
            }
            employees = expandedEmployees;
        }
    }

    // Remove an employee and shift remaining records left
    private void removeEmployee(Employee employee) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i] == employee) {
                for (int j = i; j < employeeCount - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--employeeCount] = null;
                return;
            }
        }
    }
}
