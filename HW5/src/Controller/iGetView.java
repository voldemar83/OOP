package Controller;


import java.util.List;
import Model.Student;

/**
 * Интерфейс для создания блока view в модели MVC
 */
public interface iGetView {
    // печать всех студентов в консоль
    void printAllStudent(List<Student> students);

    // метод для вывода в консоль сообщения message, и приема слова из консоли
    String prompt();

    // метод вывода сообщения о выходе из программы
    void sayBye();

    // запрос id удаляемого студента
    Long getStudentIdToDelete();

    // Сообщение, "не нашелся студент для удаления"
    void noFindStudentToDelete();

    // Сообщение об успешном удалении
    void sucсessDeleteStudent();
}