package StudentDomen;

/**
 * Класс Пользователь, описывающий человека, который может быть связан с
 * Деканатом
 */

 public class User {
    private String firstName;
    private String secondName;
    private int age;

    /**
     * конструктор
     * 
     * @param firstName  имя
     * @param secondName фамилия
     * @param age        возраст
     */
    public User(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    /* получение имени */
    public String getFirstName() {
        return firstName;
    }

    /* установить имя */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /* получение фамилии */
    public String getSecondName() {
        return secondName;
    }

    /* установить фамилию */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /* получение возраста */
    public int getAge() {
        return age;
    }

    /* установить возраст */
    public void setAge(int age) {
        this.age = age;
    }

    /* перегрузка методы вывода */
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }
}