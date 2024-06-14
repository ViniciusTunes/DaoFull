package DAO_Full;

public class Employee {
    private int id;
    private int employeeId;
    private String firstName;
    private String lastName;
    private String departmentName;

    public Employee(int id, int employeeId, String firstName, String lastName, String departmentName) {
        this.id = id;
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID:" + id +
                ", employee ID:" + employeeId +
                ", First Name:" + firstName + '\'' +
                ", Last Name:" + lastName + '\'' +
                ", department Name='" + departmentName + '\'' +
                '}';
    }
}
