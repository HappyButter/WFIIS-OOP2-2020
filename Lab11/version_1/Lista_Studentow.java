import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Lista_Studentow {
    private ArrayList<Student> students = new ArrayList<>();
    private Comparator<Student> compareByName = Comparator.comparing(Student::getImie);
    private Comparator<Student> compareBySurname = Comparator.comparing(Student::getNazwisko);
    private Comparator<Student> compareByAge = Comparator.comparing(Student::getWiek);

    public void add(Student student){
        students.add(student);
    }

    public void add(String name, String surname, int age) {
        students.add(new Student(name, surname, age));
    }

    public void wypisz_wszystkich() {
        for (Student student : this.students) {
            System.out.println(student);
        }
    }

    public void sort_imie_rosnaca() {
        Collections.sort(this.students, this.compareByName);
    }

    public void sort_imie_malejaca() {
        Collections.sort(this.students, this.compareByName.reversed());
    }

    public void sort_nazwisko_rosnaca() {
        Collections.sort(this.students, this.compareBySurname);
    }

    public void sort_nazwisko_malejaca() {
        Collections.sort(this.students, this.compareBySurname.reversed());
    }

    public void sort_wiek_rosnaca() {
        Collections.sort(this.students, this.compareByAge.reversed());
    }

    public void sort_wiek_malejaca() {
        Collections.sort(this.students, this.compareByAge);
    }
}
