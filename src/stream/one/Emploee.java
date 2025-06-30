package stream.one;

public class Emploee {

    public String getName() {
        return name;
    }

    public String getDepartomint() {
        return departomint;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartomint(String departomint) {
        this.departomint = departomint;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private String name;
    private String departomint;
    private double salary;

    public Emploee(String newDepartomint, String newName, double newSalary) {
        this.departomint = departomint;
        this.name = newName;
        this.salary = newSalary;
    }
}

