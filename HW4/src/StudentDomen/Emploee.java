package StudentDomen;

/**
 * Класс Работник дочерний от Пользователь
 */
public class Emploee extends User {

    private int empId;

    /**
     * конструктор класса
     * 
     * @param firstName  имя
     * @param secondName фамилия
     * @param age        возраст
     * @param studentID  идентификационный номер
     */
    public Emploee(String firstName, String secondName, int age, int empId) {
        super(firstName, secondName, age);
        this.empId = empId;
    }

    /* получение идентификационного номера работника */
    public int getEmpId() {
        return empId;
    }

    /* установка идентификационного номера работника */
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    /* перегрузка метода вывода */
    @Override
    public String toString() {
        return "Employee{"

                + "firstName=" + super.getFirstName()
                + ", secondName=" + super.getSecondName()
                + ", age=" + super.getAge() +
                ", empID=" + empId +
                '}';
    }

}