import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import StudentDomen.Student;
import StudentDomen.StudentFlow;
import StudentDomen.StudentGroup;

public class App {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Сергей", "Иванов", 22, (long) 401);
        Student s2 = new Student("Андрей", "Сидоров", 22, (long) 111);
        Student s3 = new Student("Иван", "Петров", 22, (long) 121);
        Student s4 = new Student("Игорь", "Иванов", 23, (long) 301);
        Student s5 = new Student("Даша", "Цветкова", 23, (long) 171);
        Student s6 = new Student("Лена", "Незабудкина", 23, (long) 104);
        Student s7 = new Student("Николай", "Иванов", 21, (long) 102);
        Student s8 = new Student("Александр", "Сидоров", 22, (long) 110);
        Student s9 = new Student("Евгений", "Петров", 22, (long) 122);
        Student s10 = new Student("Савелий", "Иванов", 23, (long) 321);
        Student s11 = new Student("Екатерина", "Цветкова", 23, (long) 131);
        Student s12 = new Student("Кристина", "Незабудкина", 23, (long) 100);

        List<Student> listStud1 = new ArrayList<Student>();
        listStud1.add(s1);
        listStud1.add(s2);
        listStud1.add(s3);
        listStud1.add(s4);
        listStud1.add(s6);
        listStud1.add(s7);
        listStud1.add(s8);
        listStud1.add(s5);
        List<Student> listStud2 = new ArrayList<Student>();
        listStud2.add(s9);
        listStud2.add(s10);
        listStud2.add(s11);
        listStud2.add(s12);

        StudentGroup group1 = new StudentGroup(listStud1, (long) 308);
        StudentGroup group2 = new StudentGroup(listStud2, (long) 304);

        List<StudentGroup> listFlow = new ArrayList<StudentGroup>();
        listFlow.add(group1);
        listFlow.add(group2);
        StudentFlow flow = new StudentFlow(listFlow);

        for (StudentGroup group : flow) {
            System.out.println("");
            System.out.println("Group:" + group.getGroupID());
            for (Student stud : group) {
                System.out.println(stud);
            }
        }

        System.out.println("============= после сортировки =============");
        Collections.sort(flow.getFlow());

        for (StudentGroup group : flow) {
            Collections.sort(group.getStudents());
        }
        for (StudentGroup group : flow) {
            System.out.println("");
            System.out.println("Group:" + group.getGroupID());
            for (Student stud : group) {
                System.out.println(stud);
            }
        }

    }
}