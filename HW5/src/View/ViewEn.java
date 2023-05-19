package View;

import java.util.List;
import java.util.Scanner;

import Controller.iGetView;
import Model.Student;

/**
 * Класс ViewEn для организации вывода на английском языке, имплементирует
 * поведение из интерфейса
 * iGetView
 */
public class ViewEn implements iGetView {
    // определение метода вывода всех студентов в консоль
    public void printAllStudent(List<Student> students) {
        System.out.println("-----Output of the list of students-----");
        for (Student person : students) {
            System.out.println(person);
        }
        System.out.println("-----End of the list-----");
    }

    // метод prompt, в котором инициализируется экземпляр Сканнера для приема слова
    // из консоли, и выводится поясняющее сообщение о происходящем
    public String prompt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the command from the list [LIST,EXIT, DELETE]:");
        return in.nextLine();
    }

    // метод вывода сообщения о выходе из программы
    public void sayBye() {
        System.out.println("Exit the program!");
    }

    // запрос id удаляемого студента
    public Long getStudentIdToDelete() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the id of student for delete:");
        return (long) in.nextInt();
    }

    // Сообщение, "не нашелся студент для удаления"
    public void noFindStudentToDelete() {
        System.out.println("There is no student with this id!");
    }

    // Сообщение об успешном удалении
    public void sucсessDeleteStudent() {
        System.out.println("The student has been successfully removed!");
    }
}