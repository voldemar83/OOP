package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Controller.iGetModel;

/**
 * Класс ModelHash для передачи данных о студентах, имплементирует интерфейс
 * iGetModel
 */
public class ModelHash implements iGetModel {
    // приватное поле список студентов
    private HashMap<Long, Student> students;

    // конструктор класса, принимает параметром список студентов
    public ModelHash(HashMap<Long, Student> students) {
        this.students = students;
    }

    // определение метода из интерфейса, возвращает список студентов

    public List<Student> getAllStudent() {

        List<Student> studList = new ArrayList<Student>();

        for (var stud : students.entrySet())
            studList.add(stud.getValue());

        return studList;
    }

    // метод удаления студента по заданному id
    public int deleteStudentById(Long id) {
        if (students.containsKey(id)) {
            students.remove(id);
            return 1;
        }
        return -1;
    }
}