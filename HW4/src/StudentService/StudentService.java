package StudentService;

import java.util.ArrayList;
import java.util.List;

import StudentDomen.Student;

/**
 * Класс Студент Сервис имплементирует интерфейс Сервис Пользователей
 */
public class StudentService implements iUserService<Student> {
    // счетчик количества элементов типа Student, так же используется в качестве
    // идентификатора для элементов
    private int count;
    // список студентов созданных внутри сервиса
    private List<Student> students;

    // конструктор класса, парпметры не принимает, определяет поле students как
    // пустой
    // массив
    public StudentService() {
        this.students = new ArrayList<Student>();
    }

    // перегрузка метода создания элемента
    @Override
    public void create(String firstName, String secondName, int age) {
        Student per = new Student(firstName, secondName, age, count);
        count++;
        students.add(per);
    }

    // перегрузка метода получения всех элементов
    @Override
    public List<Student> getAll() {
        return students;
    }

}