package View;

import java.util.List;
import java.util.Scanner;

import Controller.iGetView;
import Model.Student;

/**
 * Класс View для организации вывода, имплементирует поведение из интерфейса
 * iGetView
 */
public class View implements iGetView {
    // определение метода вывода всех студентов в консоль
    public void printAllStudent(List<Student> students) {
        System.out.println("-----Вывод списка студентов-----");
        for (Student person : students) {
            System.out.println(person);
        }
        System.out.println("-----Конец списка-----");
    }

    // метод prompt, в котором инициализируется экземпляр Сканнера для приема слова
    // из консоли, и выводится поясняющее сообщение о происходящем
    public String prompt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите команду из списка [LIST,EXIT, DELETE]:");
        return in.nextLine();
    }

    // метод вывода сообщения о выходе из программы
    public void sayBye() {
        System.out.println("Выход из программы!");
    }

    // запрос id удаляемого студента
    public Long getStudentIdToDelete() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите id студента, которого хотите удалить:");
        return (long) in.nextInt();
    }

    // Сообщение, "не нашелся студент для удаления"
    public void noFindStudentToDelete() {
        System.out.println("Нет студента с таким id");
    }

    // Сообщение об успешном удалении
    public void sucсessDeleteStudent() {
        System.out.println("Студент успешно удален!");
    }

}