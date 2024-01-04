package Task2StudentGradeCalculator;
import java.util.*;

class StudentGradeCalculator 
{
    static int numOfSub, subMarks = 0, totalMarks = 0;
    static float avgPerc;
    
    public static void gradeCheck()
    {
        if (avgPerc <= 100 && avgPerc >= 85) 
        {
            System.out.println("A");
        }
        else if (avgPerc <= 84 && avgPerc >= 70) 
        {
            System.out.println("B");
        }
        else if (avgPerc <= 69 && avgPerc >= 50) 
        {
            System.out.println("C");
        }
        else if (avgPerc <= 49 && avgPerc >= 35) 
        {
            System.out.println("D");
        }
        else
        {
            System.out.println("F");
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of subjects: ");
        numOfSub = sc.nextInt();
        System.out.println();

        String subjectName[] = new String[numOfSub];
        int marks[] = new int[numOfSub];

        for (int i = 0; i < numOfSub; i++) 
        {
            System.out.println("Enter the name of subject " + (i+1));
            subjectName[i] = sc.next();
           
            System.out.println("");
        }

        System.out.println("---------------------------------------------------");

        System.out.format("%7s %14s", "No.", "Subject Name");
        System.out.println();

        System.out.println("---------------------------------------------------");

        for (int i = 0; i < numOfSub; i++) 
        {
            System.out.format("%7s %14s", (i+1),subjectName[i]);
            System.out.println();
        }

        System.out.println("---------------------------------------------------");
        System.out.println();

        System.out.println("Enter the marks out of 100");
        for (int i = 0; i < numOfSub; i++) 
        {
            System.out.print(subjectName[i] + ": ");
            subMarks = sc.nextInt();
            marks[i] = subMarks;
            totalMarks = totalMarks + subMarks;
        }

        System.out.println();
        System.out.println("---------------------------------------------------");

        System.out.format("%7s %14s %7s", "No.", "Subject Name", "Marks");
        System.out.println();

        System.out.println("---------------------------------------------------");

        for (int i = 0; i < numOfSub; i++) 
        {
            System.out.format("%7s %14s %7s", (i+1), subjectName[i], marks[i]);
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
        System.out.format("%7s %14s %7s", "", "Total: ", totalMarks);
        System.out.println();
        System.out.println("---------------------------------------------------");

        
        System.out.println();
        avgPerc = totalMarks / numOfSub;

        System.out.println("Average Percentage: " + avgPerc);

        System.out.print("Grade: ");
        gradeCheck();
        System.out.println();
        sc.close();
    }

}
