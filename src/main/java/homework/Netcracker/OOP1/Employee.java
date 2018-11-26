package homework.Netcracker.OOP1;

import java.util.Objects;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName(String lastName, String firstName){
        return firstName + ' ' + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return salary * 12;
    }
    public int raiseSalary(int percent) {
        return salary + Math.round(salary * percent / 100);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=?, " +
                "name=" + firstName + ' ' + lastName +
                ", salary=?" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                salary == employee.salary &&
                firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + id;
        result = result * 31 + salary;
        result = result * 31 + firstName.hashCode();
        result = result * 31 + lastName.hashCode();
        return result;
    }
}
