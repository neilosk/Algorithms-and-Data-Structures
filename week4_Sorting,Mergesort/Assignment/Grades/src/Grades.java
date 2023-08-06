import java.util.Scanner;

import edu.princeton.cs.algs4.Insertion;

public class Grades {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
       
        try{
            int n = scanner.nextInt();
            Student[] students = new Student[n];
            scanner.nextLine();
            for(int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                students[i] = new Student(input[0], input[1]);
            }

            Insertion.sort(students);

            for (Student student : students) {
                System.out.println(student);
            }

        }
        catch(Exception e) {
            System.out.println("Invalid input");
            System.exit(0);
        }
        scanner.close();
    }
}

