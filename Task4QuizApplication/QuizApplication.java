package Task4QuizApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizApplication 
{
    static ArrayList quizList;
    static ArrayList quizSummaryList;
    static Quiz quiz;
    static QuizSummary quizSummary;
    static int idCounter;
    static Quiz quizQuestion;
    static int totalScore;
    static int questionTimeDurationInSeconds = 5;

    public static void main(String[] args) 
    {
        quizList = new ArrayList<Quiz>();
        initQuiz();

        welcomeQuizAppMessage();

        Scanner sc = new Scanner(System.in);

        quizSummaryList = new ArrayList<QuizSummary>();

        for (int questionNo = 1; questionNo <= 5; questionNo++) 
        {
            displayQuestion(questionNo);
            verifyQuestionOption(questionNo, sc.nextInt());
        }
        
        
        generateQuizSummary();
        System.out.println("\n===================================");
        System.out.println("  Your total score is: " + totalScore);
        System.out.println("===================================\n");

    }

    private static void initQuiz() 
    {
        idCounter++;

        quiz = new Quiz(idCounter, "What company makes the Xperia model of smartphone?", 
        "Samsung", "Sony", "Nokia", 2); 
        quizList.add(quiz);

        idCounter++;
        quiz = new Quiz(idCounter, "Where was the first example of paper money used?", 
        "China", "Turkey", "Greece", 1); 
        quizList.add(quiz);

        idCounter++;
        quiz = new Quiz(idCounter, "Who is generally considered the inventor of the motor car?", 
        "Henry Ford", "Karl Benz", "Henry M. Leland", 2); 
        quizList.add(quiz);

        idCounter++;
        quiz = new Quiz(idCounter, "The fear of insects is known as what?", 
        "Entomophobia", "Arachnophobia", "Ailurophobia", 1); 
        quizList.add(quiz);

        idCounter++;
        quiz = new Quiz(idCounter, "Which app has the most total users?", 
        "TikTok", "Snapchat", "Instagram", 3); 
        quizList.add(quiz);
    }

    static void welcomeQuizAppMessage()
    {
        System.out.println("\n==== Welcome to Quiz App===== " );
    }

    static void displayQuestion(int questionNumber)
    {
        quizQuestion = (Quiz) quizList.get(questionNumber - 1);
        System.out.println(quizQuestion.id + ") " + quizQuestion.question);
        System.out.println("\n1. " + quizQuestion.option1);
        System.out.println("2. " + quizQuestion.option2);
        System.out.println("3. " + quizQuestion.option3);
        System.out.println("\n Select a correct option from above.\n");
    }

    private static void verifyQuestionOption(int questionNumber, int selectedOption) 
    {
        quizQuestion = (Quiz) quizList.get(questionNumber - 1);

        if (quizQuestion.correctOption == selectedOption) 
        {
            System.out.println("Correct answer!\n");
            totalScore += 20;
        }
        else
        {
            System.out.println("Incorrect answer!");
        }
        quizSummary = new QuizSummary(questionNumber, quizQuestion.correctOption, selectedOption);

        quizSummaryList.add(quizSummary);
    }

    private static void generateQuizSummary() 
    {
        
        System.out.println();
        System.out.println("###### QUIZ SUMMARY ######\n");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.format("%7s %15s %54s %14s", "Q No.","Question", "Correct", "Selected");

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------");

        for (int i = 0; i < quizSummaryList.size(); i++) 
        {
            int question_No = ((QuizSummary) quizSummaryList.get(i)).questionNumber;
            int selected_Option = ((QuizSummary) quizSummaryList.get(i)).selectedOption;
            int correct_Option = ((QuizSummary) quizSummaryList.get(i)).correctOption;

            Quiz quiz = (Quiz) quizList.get(i);

            String selected_Option_Value = "";
            String correct_Option_Value = "";


            switch (selected_Option) 
            {
                case 1:
                    selected_Option_Value = quiz.option1;
                    break;

                case 2:
                    selected_Option_Value = quiz.option2;
                    break;

                case 3:
                    selected_Option_Value = quiz.option3;
                    break;
            
                default:
                    break;
            }

            switch (correct_Option) 
            {
                case 1:
                    correct_Option_Value = quiz.option1;
                    break;

                case 2:
                    correct_Option_Value = quiz.option2;
                    break;

                case 3:
                    correct_Option_Value = quiz.option3;
                    break;
            
                default:
                    break;
            }

            quizQuestion = (Quiz) quizList.get(question_No - 1);
            System.out.format("%4s %55s %14s %14s", question_No, quizQuestion.question, correct_Option_Value, selected_Option_Value);
            System.out.println();
        }
    }
}

class Quiz
{
    int id, correctOption;
    String question, option1, option2, option3;

    public Quiz(int id, String question, String option1, String option2, String option3, int correctOption) 
    {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correctOption = correctOption;
    }
}


