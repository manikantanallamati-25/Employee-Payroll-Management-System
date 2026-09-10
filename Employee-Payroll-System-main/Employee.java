/**
 * Employee Class - Represents an employee in the payroll system
 * Demonstrates: Encapsulation, Constructors, Getters/Setters
 */
public class Employee {
    
    // Private variables - Encapsulation
    private int id;
    private String name;
    private String department;
    private String designation;
    private double basicSalary;
    
    // Constructor
    public Employee(int id, String name, String department, 
                    String designation, double basicSalary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.basicSalary = basicSalary;
    }
    
    // Getters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public double getBasicSalary() {
        return basicSalary;
    }
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public void setBasicSalary(double basicSalary) {
        if (basicSalary > 0) {
            this.basicSalary = basicSalary;
        } else {
            System.out.println("Salary must be positive!");
        }
    }
    
    // toString() method - for easy display
    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Department: %s | Designation: %s | Salary: %.2f",
                id, name, department, designation, basicSalary);
    }

   
}
