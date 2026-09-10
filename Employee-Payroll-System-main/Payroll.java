/**
 * Payroll Class - Handles salary calculations
 * Salary Structure:
 * Gross Salary = Basic + HRA + DA + Allowance
 * Net Salary = Gross Salary - Deductions
 */
public class Payroll {
    
    // Salary components percentages
    private static final double HRA_PERCENTAGE = 0.20;      // 20%
    private static final double DA_PERCENTAGE = 0.10;       // 10%
    private static final double ALLOWANCE_PERCENTAGE = 0.05; // 5%
    private static final double DEDUCTION_PERCENTAGE = 0.05; // 5%
    
    private Employee employee;
    private double hra;
    private double da;
    private double allowance;
    private double grossSalary;
    private double deduction;
    private double netSalary;
    
    // Constructor
    public Payroll(Employee employee) {
        this.employee = employee;
        calculateSalary();
    }
    
    // Calculate all salary components
    private void calculateSalary() {
        double basicSalary = employee.getBasicSalary();
        
        this.hra = basicSalary * HRA_PERCENTAGE;
        this.da = basicSalary * DA_PERCENTAGE;
        this.allowance = basicSalary * ALLOWANCE_PERCENTAGE;
        
        this.grossSalary = basicSalary + this.hra + this.da + this.allowance;
        
        this.deduction = this.grossSalary * DEDUCTION_PERCENTAGE;
        this.netSalary = this.grossSalary - this.deduction;
    }
    
    // Getters
    public Employee getEmployee() {
        return employee;
    }
    
    public double getHRA() {
        return hra;
    }
    
    public double getDA() {
        return da;
    }
    
    public double getAllowance() {
        return allowance;
    }
    
    public double getGrossSalary() {
        return grossSalary;
    }
    
    public double getDeduction() {
        return deduction;
    }
    
    public double getNetSalary() {
        return netSalary;
    }
    
    // Display Payroll Details
    public void displayPayroll() {
        System.out.println("\n========== PAYROLL ==========");
        System.out.println("Employee       : " + employee.getName());
        System.out.println("Basic Salary   : ₹" + String.format("%.2f", employee.getBasicSalary()));
        System.out.println("HRA            : ₹" + String.format("%.2f", hra));
        System.out.println("DA             : ₹" + String.format("%.2f", da));
        System.out.println("Allowance      : ₹" + String.format("%.2f", allowance));
        System.out.println("Gross Salary   : ₹" + String.format("%.2f", grossSalary));
        System.out.println("Deduction      : ₹" + String.format("%.2f", deduction));
        System.out.println("-----------------------------");
        System.out.println("Net Salary     : ₹" + String.format("%.2f", netSalary));
        System.out.println("=============================\n");
    }
    
    // Generate Payslip
    public void generatePayslip() {
        System.out.println("\n========================================");
        System.out.println("             SALARY SLIP");
        System.out.println("========================================");
        System.out.println("\nEmployee ID     : " + employee.getId());
        System.out.println("Employee Name   : " + employee.getName());
        System.out.println("Department      : " + employee.getDepartment());
        System.out.println("Designation     : " + employee.getDesignation());
        System.out.println("\n----------------------------------------");
        System.out.println("Basic Salary    : ₹" + String.format("%.2f", employee.getBasicSalary()));
        System.out.println("HRA             : ₹" + String.format("%.2f", hra));
        System.out.println("DA              : ₹" + String.format("%.2f", da));
        System.out.println("Allowance       : ₹" + String.format("%.2f", allowance));
        System.out.println("----------------------------------------");
        System.out.println("Gross Salary    : ₹" + String.format("%.2f", grossSalary));
        System.out.println("Deduction       : ₹" + String.format("%.2f", deduction));
        System.out.println("----------------------------------------");
        System.out.println("NET SALARY      : ₹" + String.format("%.2f", netSalary));
        System.out.println("========================================\n");
    }
}
