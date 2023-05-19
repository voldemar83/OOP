package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.iGetModel;

/**
 * Класс FileRepo для передачи данных о студентах из файла, имплементирует
 * интерфейс
 * iGetModel
 */
public class FileRepo implements iGetModel {
    // приватное поле Имя файла для чтения и записи
    private String fileName;
    // приватное поле список студентов
    private List<Student> students;

    /**
     * конструктор класса, принимает параметр
     * 
     * @param fileName Имя файла
     */
    public FileRepo(String fileName) {
        this.fileName = fileName;
        this.students = new ArrayList<>();
        // попробуй создать файл с именем fileName, если удалось, закрываем его, иначе
        // вывести ошибку в консоль
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Метод добавления студента в список
    public void addStudent(Student student) {
        this.students.add(student);
    }

    // метод удаления студента по заданному id
    public int deleteStudentById(Long id) {
        int i = -1;
        for (Student pers : students) {
            if (pers.getStudentID() == id) {
                i = students.indexOf(pers);
            }
        }
        students.remove(i);
        return i;
    }

    // Метод чтения всех студентов из файла
    public void readAllStudentsFromFile() {
        try {
            File file = new File(fileName); // создаем file - экземпляр класса File, передаем имя файла fileName, кот.
                                            // хотим прочитать
            FileReader fr = new FileReader(file); // создаем fr - экземпляр класса FileReader, передаем file ему
            BufferedReader reader = new BufferedReader(fr); // создаем reader - экземпляр класса BufferedReader,
                                                            // добавляем в буфер обмена содержимое прочитанного файла
            String line = reader.readLine();// line - сторока из файла
            // пока есть строки
            while (line != null) {
                String[] param = line.split(" ");// разделяем строку по пробелу, создается массив строк param
                // создаем нового студента на основе считанных данных
                Student pers = new Student(param[0], param[1], Integer.parseInt(param[2]), Long.parseLong(param[3]));
                students.add(pers);// добавляем его в список
                line = reader.readLine();// переопределяем line - следующая строка
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());// выводим ошибку, если не получилось считать файл
        }
    }

    // Метод для сохранения студентов в файл
    public void saveAllStudentToFile() {
        try (FileWriter fw = new FileWriter(fileName, true)) {// создаем файл
            for (Student pers : students) {// проходим циклом по списку студентов
                fw.write(pers.getFirstName() + " " + pers.getSecondName() + " " + pers.getAge() + " "
                        + pers.getStudentID());// записываем строку с данными студента
                fw.append('\n');// переход на новую строку
            }
            fw.flush();// закрываем файл
        } catch (Exception e) {
            System.out.println(e.getMessage());// вывод ошибки, если не удалось создать файл
        }
    }

    // перегрузка метода вывода всех студентов
    @Override
    public List<Student> getAllStudent() {
        if (students.isEmpty()) {
            readAllStudentsFromFile();
        } // считываем всех студентов из файла, добавляем в поле students
        return students;// возвращаем содержимое поля students
    }

}