package Controller;

import java.util.List;
import Model.Student;

/**
 * Интерфейс для создания блока model в модели MVC
 */
public interface iGetModel {
    // метод получения всех студентов
    public List<Student> getAllStudent();

    // метод удаления студента по заданному id
    public int deleteStudentById(Long id);
}