package Controller;

import java.util.ArrayList;
import java.util.List;

// import javax.jws.WebParam.Mode;

import Model.Student;

/**
 * Класс Controller - связующее звено View и Model
 */
public class Controller {
    // приватное поле список студентов
    private List<Student> students;
    // приватные поля блоков view и model архитектуры MVC
    private iGetView view;
    private iGetModel model;

    /**
     * конструктор класса
     * 
     * @param view  блок view, экземпляр класса, содержащего интерфейс iGetView
     * @param model блок model, экземпляр класса, содержащего интерфейс iGetMode
     */
    public Controller(iGetView view, iGetModel model) {
        this.view = view;
        this.model = model;
        this.students = new ArrayList<Student>();
    }

    // метод получения всех студентов, получаем их из блока model
    public void getAllStudent() {
        students = model.getAllStudent();
    }

    // метод проверки получаемых данных
    public boolean testData() {
        if (students.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // метод вывода студентов через блок view
    public void updateView() {
        // MVP
        getAllStudent();
        if (testData()) {
            view.printAllStudent(students);
        } else {
            System.out.println("Список студентов пуст!");
        }

        // MVC
        // view.printAllStudent(model.getAllStudent());
    }

    // метод, запускающий взаимодействие с пользователем
    public void run() {
        Commands com = Commands.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            // command - новая команда от пользователя
            String command = view.prompt();
            try {
                com = Commands.valueOf(command.toUpperCase());

                // обработка вводимой команды
                switch (com) {
                    case EXIT:// выход
                        getNewIteration = false;
                        view.sayBye();
                        break;
                    case LIST:// печать студентов
                        updateView();
                        break;
                    case DELETE:// удаление студента
                        Long id = view.getStudentIdToDelete();
                        int indexStudentToDelete = model.deleteStudentById(id);
                        if (indexStudentToDelete < 0) {
                            view.noFindStudentToDelete();
                        } else {
                            view.sucсessDeleteStudent();
                        }
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Incorrect, try again!");
            }

        }
    }

}