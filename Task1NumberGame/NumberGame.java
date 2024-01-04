package Task1NumberGame;
import java.util.*;

class NumberGame
{
    int randomNum, guessedNum, finalScore, maxAttempts = 5, countOfTries = 0, maxRange = 100;
    boolean correctGuess = false;

    public void guessNumber()
    {
        Scanner sc = new Scanner(System.in);

        Random rc = new Random();

        randomNum = rc.nextInt(maxRange) + 1;

       while (!correctGuess) 
       {
            

            if (countOfTries < maxAttempts) 
            {
                System.out.println("Enter the number to be guessed from 1 to 100: ");
                guessedNum = sc.nextInt();

                if (guessedNum < randomNum) 
                {
                    System.out.println("The guessed number is lesser than the correct number");
                    countOfTries++;
                }
                else if (guessedNum > randomNum) 
                {
                    System.out.println("The guessed number is greater than the correct number");  
                    countOfTries++;
                }
                else
                {
                    System.out.println("You guessed it correct");
                    countOfTries++;
                    finalScore = calculateScore(countOfTries);
                    System.out.println("Your score is: " + finalScore + " out of 100");
                    playAgain();
                    //break;
                }
                System.out.println(countOfTries);
            }
            else
            {
                System.out.println("Sorry, You have reached maximum numbers of attempts!");
                playAgain();
            }
        }
        sc.close();
    }

    public int calculateScore(int countOfTries)
    {
        if (countOfTries == 1) 
        {
            finalScore = 100;
        }
        else if (countOfTries == 2) 
        {
            finalScore = 80;    
        }
        else if (countOfTries == 3) 
        {
            finalScore = 60;    
        }
        else if (countOfTries == 4) 
        {
            finalScore = 40;    
        }
        else if (countOfTries == 5) 
        {
            finalScore = 20;    
        }
        return finalScore;
    }

    public void playAgain()
    {
        System.out.println("Do you want to play again?");
        System.out.println("1. Play Again 2. Quit");

        Scanner sc2 = new Scanner(System.in);
        int playAgain = sc2.nextInt();

        if(playAgain == 1)
        {
            countOfTries = 0;
            guessNumber();
        }
        else
        {
            finalScore = calculateScore(countOfTries);
            System.out.println("Your score is: " + finalScore + " out of 100");
        }
        sc2.close();
    }

    public static void main(String[] args) 
    {
        NumberGame obj = new NumberGame();
        obj.guessNumber();
    }
}