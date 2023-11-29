

import java.util.LinkedList;
import java.util.Scanner;

public class StudentGradeCalculator {

    static Float marksPerSubject = 100.00f;
    static char result;
    static LinkedList<String> subjects = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    static {
        System.out.println("-*-*-*-*-*--*-*-*-*-Welcome to Student Grade Calculator-*-*-*-*-*-*-*-*-*-*-");

    }

    public static void main(String[] args) {

        LinkedList<Float> marks = StudentGradeCalculator.input();

        Float obtained = 0f;
        for (Float float1 : marks) {
            obtained = obtained + float1;
        }

        char grade = StudentGradeCalculator.gardeCalculator(marksPerSubject * subjects.size(), obtained);

        Float percentage = StudentGradeCalculator.percentage(marksPerSubject * subjects.size(), obtained);
        StudentGradeCalculator.display(marks, obtained, grade, percentage);

        System.out.println("Press [y] to calculate grade of some other student ");
        System.out.println("Press [n] to terminate program");

        char choice = scanner.next().charAt(0);
        if (choice == 'y')
            StudentGradeCalculator.main(null);
        else if (choice == 'n')
            System.out.println("-*-*-*-*-*--*-*-*-*-*-*-*-*-*-Thank You-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

        else {
            System.out.println("Invalid entry");
            System.out.println("-*-*-*-*-*--*-*-*-*-*-*-*-*-*-Thank You-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        }
    }

    private static void display(LinkedList<Float> marks, Float obtained, char grade, Float percentage) {
        System.out.println("-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*Final Result-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*");
        System.out.println("_._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._.");

        System.out.print("|| " + StudentGradeCalculator.print("Subjects", 15));
        System.out.print(" | " + StudentGradeCalculator.print("Total Marks", 11));
        System.out.print(" | " + StudentGradeCalculator.print("Obtained Marks", 14));
        System.out.print(" | " + StudentGradeCalculator.print("Percentage", 10));
        System.out.print(" | " + StudentGradeCalculator.print("Grade", 5) + " ||");
        System.out.println();
        for (int i = 0; i < subjects.size(); i++) {
            System.out.print("|| " + StudentGradeCalculator.print(subjects.get(i), 15));
            System.out.print(" | " + StudentGradeCalculator.print(marksPerSubject.toString(), 11));
            System.out.print(" | " + StudentGradeCalculator.print(marks.get(i).toString(), 14));
            System.out.print(" | " + StudentGradeCalculator
                    .print(StudentGradeCalculator.percentage(marksPerSubject, marks.get(i)).toString(), 10));
            System.out
                    .print(" | "
                            + StudentGradeCalculator
                                    .print(Character.toString(
                                            StudentGradeCalculator.gardeCalculator(marksPerSubject, marks.get(i))), 5)
                            + " ||");
            if (StudentGradeCalculator.gardeCalculator(marksPerSubject, marks.get(i)) == 'F')
                grade = 'F';
            System.out.println();

        }
        System.out.println("_._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._.");

        System.out.println("Total marks obtained:- " + obtained);
        System.out.println("Average Percentage Obtained:- " + percentage + "%");
        System.out.println("Grade Obtained:- " + grade);

    }

    public static LinkedList<Float> input() {
        LinkedList<Float> list = new LinkedList<>();
        System.out.println("Enter subjects and marks");
        System.out.println("Type [done] when entered");
        String temp1 = "";
        while (true) {
            System.out.println("Enter subject name:- ");
            temp1 = scanner.next();
            if (temp1.equals("done"))
                break;
            System.out.println("Enter markes obtained in " + temp1 + ":-");
            Float temp2 = scanner.nextFloat();
            subjects.offer(temp1);
            list.add(temp2);
        }

        return list;
    }

    public static char gardeCalculator(Float total, Float obtained) {
        char grade = '#';

        Float oneFifth = (total / 5);
        if (obtained < total && obtained >= 4 * oneFifth)
            grade = 'A';
        else if (obtained < 4 * oneFifth && obtained >= 3 * oneFifth)
            grade = 'B';
        else if (obtained < 3 * oneFifth && obtained >= 2 * oneFifth)
            grade = 'C';
        else if (obtained < 2 * oneFifth && obtained >= total / 3)
            grade = 'D';
        else if (obtained < total / 3)
            grade = 'F';
        return grade;
    }

    public static Float percentage(Float total, Float obtained) {
        return (obtained / total) * 100;
    }

    public static String print(String str, int x) {
        char[] arr = new char[x];
        int i = 0;
        for (int j = 0; j < x; j++) {
            arr[j] = '_';
        }
        for (char c : str.toCharArray()) {
            arr[i] = c;
            i++;
        }
        String str2 = "";

        for (char c : arr) {
            str2 = str2 + c;
        }

        return str2;
    }

}
