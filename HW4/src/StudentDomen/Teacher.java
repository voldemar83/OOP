package StudentDomen;

/**
 * Класс Преподаватель дочерний от Пользователь
 */
public class Teacher extends User {

    private int teacerId;
    private String academicDegree;

    /**
     * конструктор класса
     * 
     * @param firstName      имя
     * @param secondName     фамилия
     * @param age            возраст
     * @param teacerId       идентификационный номер
     * @param academicDegree ученая степень
     */
    public Teacher(String firstName, String secondName, int age, int teacerId, String academicDegree) {
        super(firstName, secondName, age);
        this.teacerId = teacerId;
        this.academicDegree = academicDegree;
    }

    /* получение идентификационного номера преподавателя */
    public int getTeacerId() {
        return teacerId;
    }

    /* установка идентификационного номера преподавателя */
    public void setTeacerId(int teacerId) {
        this.teacerId = teacerId;
    }

    /* получение ученой степени преподавателя */
    public String getLevel() {
        return academicDegree;
    }

    /* установка ученой степени преподавателя */
    public void setLevel(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    /* перегрузка метода вывода */
    @Override
    public String toString() {
        return "Teacher{"

                + "firstName=" + super.getFirstName()
                + ", secondName=" + super.getSecondName()
                + ", age=" + super.getAge() +
                ", teacerId=" + teacerId +
                ", academicDegree=" + academicDegree +
                '}';
    }

}