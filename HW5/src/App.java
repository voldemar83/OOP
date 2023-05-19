import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Controller.Controller;
import Controller.iGetModel;
import Controller.iGetView;
import Model.FileRepo;
import Model.Model;
import Model.ModelHash;
import Model.Student;
import View.View;
import View.ViewEn;

public class App {
   // Функция запроса языка пользователя
   public static iGetView SelectLanguageView() {
      Scanner in = new Scanner(System.in);
      boolean correctAnswer = false;
      while (!correctAnswer) {
         System.out.println(
               "Выберите язык/Сhoose a language.\n1 - Русский\n2 - English\nВведите цифру выбранного языка/Enter the number of the selected language:");
         int answer = in.nextInt();
         if (answer == 1) {
            correctAnswer = true;
            return new View();
         } else if (answer == 2) {
            correctAnswer = true;
            return new ViewEn();
         } else {
            System.out.println("Некорректный ввод/Incorrect input\n");
         }
      }
      return null;
   }

   public static iGetModel SelectModel() {
      Scanner in = new Scanner(System.in);
      boolean correctAnswer = false;
      while (!correctAnswer) {
         System.out.println(
               "Выберите модель работы с данными.\n1 - Работа с List\n2 - Работа с HashMap\n3 - Работа с файлом\nВведите цифру выбранной модели:");
         int answer = in.nextInt();
         if (answer == 1) {
            correctAnswer = true;
            // создаем список студентов
            List<Student> students = new ArrayList<Student>();
            Student s1 = new Student("Сергей", "Иванов", 21, (long) 101);
            Student s2 = new Student("Андрей", "Сидоров", 22, (long) 111);
            Student s3 = new Student("Иван", "Петров", 22, (long) 121);
            Student s4 = new Student("Игорь", "Иванов", 23, (long) 301);
            Student s5 = new Student("Даша", "Цветкова", 25, (long) 171);
            Student s6 = new Student("Лена", "Незабудкина", 23, (long) 104);
            students.add(s1);
            students.add(s2);
            students.add(s3);
            students.add(s4);
            students.add(s5);
            students.add(s6);
            return new Model(students);
         } else if (answer == 2) {
            correctAnswer = true;
            HashMap<Long, Student> hashStudents = new HashMap<Long, Student>();
            Student s1 = new Student("Сергей", "Иванов", 21, (long) 101);
            Student s2 = new Student("Андрей", "Сидоров", 22, (long) 111);
            Student s3 = new Student("Иван", "Петров", 22, (long) 121);
            Student s4 = new Student("Игорь", "Иванов", 23, (long) 301);
            Student s5 = new Student("Даша", "Цветкова", 25, (long) 171);
            Student s6 = new Student("Лена", "Незабудкина", 23, (long) 104);
            hashStudents.put((long) 101, s1);
            hashStudents.put((long) 111, s2);
            hashStudents.put((long) 121, s3);
            hashStudents.put((long) 301, s4);
            hashStudents.put((long) 171, s5);
            hashStudents.put((long) 104, s6);
            // Создаем экземпляр класса ModelHash
            return new ModelHash(hashStudents);
         } else if (answer == 3) {
            correctAnswer = true;
            // при первом запуске, необходимо внести данные в файл
            //
            // fileRepo.saveAllStudentToFile();
            return new FileRepo("StudentDb.txt");
         } else {
            System.out.println("Некорректный ввод\n");
         }
      }
      return null;
   }

   public static void main(String[] args) throws Exception {

      // Выбираем модель, с которой будем работать
      iGetModel model = SelectModel();
      // Выбираем язык View
      iGetView view = SelectLanguageView();
      // Создаем экземпляр класса Controller с параметрами view, model
      Controller control = new Controller(view, model);
      // Запускаем метод взаимодействия с пользователем
      control.run();

      // control.updateView();

   }
}