public class Student {
    private int age;
    private String name;
    private String surname;

    Student(){}

    Student(String name, String surname, int age){
        this.name = name;
        this.surname =surname;
        this.age = age;
    }

    public void setImie(String name) {
        this.name = name;
    }

    public void setNazwisko(String surname) {
        this.surname = surname;
    }

    public void setWiek(int age) {
        this.age = age;
    }

    public String getImie() {
        return this.name;
    }

    public String getNazwisko() {
        return this.surname;
    }

    public int getWiek() {
        return this.age;
    }

    @Override
    public String toString() {
        return name + " " +
                surname + " " +
                age;
    }
}

