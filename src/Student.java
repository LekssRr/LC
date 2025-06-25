public class Student{
    public String lastName;
    public String firstName;
    public String middleName;
    public String name;
    public boolean is;

    public Student(String newLastName, String newFistName, String newMiddleName, String newName, boolean newIs){
        this.lastName = newLastName;
        this.firstName = newFistName;
        this.middleName = newLastName;
        this.name = newName;
        this.is = newIs;

    }
    @Override
    public boolean equals(Object o) {
        if(o.toString().equals(this.toString())){
           Student s = (Student)o;
           return s.name.equals(this.name);
        }
        return false;
    }
    @Override
    public String toString(){
        return this.lastName;
    }
}
