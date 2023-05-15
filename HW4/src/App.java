import java.net.NoRouteToHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import Controllers.EmploeeController;
import StudentDomen.AverageAge;
import StudentDomen.Emploee;
import StudentDomen.Student;
import StudentDomen.StudentFlow;
import StudentDomen.StudentGroup;
import StudentDomen.Teacher;
import StudentDomen.User;
import StudentService.EmploeeService;
import StudentService.StudentService;
import StudentService.TeacherService;

public class App {
    public static void main(String[] args) throws Exception {

        // Создаем сервис студентов - экземпляр класса StudentService
        StudentService serv = new StudentService();
        // Добавляем студентов внутрь сервиса
        serv.create("Коптерев", "Федор", 20);
        serv.create("Коптерева", "Дарина", 22);
        // Выводим список студентов внутри сервиса
        System.out.println("Список студентов:");
        System.out.println(serv.getAll());
        // Создаем сервис работников - экземпляр класса EmploeeService
        EmploeeService servEmp = new EmploeeService();
        // Добавляем работников внутрь сервиса
        servEmp.create("Коптерева", "Дарья", 52);
        servEmp.create("Шинкарюк", "София", 52);
        servEmp.create("Коптерева", "Алевтина", 52);
        servEmp.create("Астафьева", "Фрося", 52);
        // Выводим список работников из сервиса
        System.out.println("Список работников:");
        System.out.println(servEmp.getAll());
        System.out.println("=============После сортировки==============");
        // Выводим отсортированный список работников из сервиса
        System.out.println(servEmp.getSortedByFIOStudentGroup());

        // Создаем сервис преподавателей - экземпляр класса TeacherService
        TeacherService servTeach = new TeacherService();
        // Добавляем преподавателей внутрь сервиса
        servTeach.create("Коптерева", "Дарья", 30, "доцент");
        servTeach.create("Шинкарюк", "София", 42);
        servTeach.create("Коптерева", "Алевтина", 52, "ст. преподав.");
        servTeach.create("Астафьева", "Фрося", 62);
        // Выводим список преподавателей из сервиса
        System.out.println("Список преподавателей:");
        System.out.println(servTeach.getAll());
        System.out.println("===========После сортировки================");
        // Выводим отсортированный список преподавателей из сервиса
        System.out.println(servTeach.getSortedByFIOStudentGroup());

        /* Вычисление средних возрастов */
        // Создаем экземпляр класса, с необходимым нам типом, затем вызываем метод
        // вычисления среднего возраста
        AverageAge<Student> averageAgeOfStudents = new AverageAge<>(serv.getAll());
        System.out.println("Средний возраст студентов: " + averageAgeOfStudents.calculateAverageAge());
        AverageAge<Teacher> averageAgeOfTeachers = new AverageAge<>(servTeach.getAll());
        System.out.println("Средний возраст преподавателей: " + averageAgeOfTeachers.calculateAverageAge());
        AverageAge<Emploee> averageAgeOfEmploee = new AverageAge<>(servEmp.getAll());
        System.out.println("Средний возраст работников: " + averageAgeOfEmploee.calculateAverageAge());

    }
}