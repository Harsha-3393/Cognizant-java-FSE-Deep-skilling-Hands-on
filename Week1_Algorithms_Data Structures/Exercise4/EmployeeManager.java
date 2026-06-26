public class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add Employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search Employee
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse Employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee
    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {

                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                employees[--size] = null;
                return true;
            }
        }
        return false;
    }
}