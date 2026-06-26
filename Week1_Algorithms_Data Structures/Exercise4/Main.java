public class Main {
    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager(5);

        Employee emp1 = new Employee(1, "Rohit", "Developer", 100000);
        Employee emp2 = new Employee(2, "Rahul", "Data Engineer", 70000);
        Employee emp3 = new Employee(3, "Ganesh", "Data Analyst", 30000);

        manager.addEmployee(emp1);
        manager.addEmployee(emp2);
        manager.addEmployee(emp3);

        System.out.println("Employees after adding:");
        manager.traverseEmployees();

        Employee searchedEmployee = manager.searchEmployee(2);
        System.out.println("\nSearched Employee with ID 2:");
        System.out.println(searchedEmployee);

        boolean isDeleted = manager.deleteEmployee(1);
        System.out.println("\nEmployee with ID 1 deleted: " + isDeleted);

        System.out.println("\nEmployees after deletion:");
        manager.traverseEmployees();

        Employee emp4 = new Employee(4, "Diana", "Designer", 55000);
        manager.addEmployee(emp4);

        System.out.println("\nEmployees after adding new employee:");
        manager.traverseEmployees();
    }
}