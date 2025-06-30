package stream.two;

public class Product {

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Product(String category, double salary) {
        this.category = category;
        this.salary = salary;
    }

    private String category;

    private double salary;

}
