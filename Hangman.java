// Group project with Nick Arsenault only
import java.util.Scanner;

public class Hangman {

    private static String[] words = {"yoasted", "sprite", "tree", "supreme", "airpods", "offwhite", "word", "mason", "london", "nick", "supreme" };
    private static String word = words[(int) (Math.random() * words.length)];
    private static String stars = new String(new char[word.length()]).replace("\0", "*");
    private static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);//input for the second game
        boolean check = true;
        String ans = "y";
        int p1 = 0;//Score for the guesser
        int p2 = 0;//If they get the word wrong it adds to the computers score
        String name = "";
        System.out.println("What's your name? ");
        name = input.nextLine();
        while (ans.equals("y") || ans.equals("Y"))//If the variable ans is y it reapeats
        {
            while (count < 7 && stars.contains("*")) {//repeats while you have guesses left
                System.out.println("Guess a letter");
                System.out.println(stars);
                String guess = input.next();
                hang(guess);
            }
            
            if (stars.contains("*")){//adds score to p2
                p2++;
            }
            else{//adds points to p1
                p1++;
            }
            
            System.out.println("    Score   ");//the scores for the players
            System.out.println("Wins: " + p1);
            System.out.println("Losses: " + p2 + "\n");
            
            System.out.println("Would you like to play again? (Y/y for yes)");
            ans = input2.next();
            //if (p1 == 3 || p2 == 3)
            count = 0;
            word = words[(int) (Math.random() * words.length)];
            stars = new String(new char[word.length()]).replace("\0", "*");//If the letter the user guessed is correct they replace the star with the letter
        }
        input.close();
    }
    
    public static void hang(String guess) {
        String newstars = "";
        
        for (int i = 0; i < word.length(); i++) { //goes through each letter of the word
                if (word.charAt(i) == guess.charAt(0)) {//if the guess is correct the program adds the correct letter to the line
                    newstars += guess.charAt(0);
                } else if (stars.charAt(i) != '*') {//checks to see if its not a star
                    newstars += word.charAt(i);
                } else {//adds a star
                    newstars += "*";
                }
        }
        
        if (stars.equals(newstars)) {//checks if the letter is right
            count++;
            hangmanDude();
        } else { //sets stars to newstars
            stars = newstars;
        }
        if (stars.equals(word)) { //checks if your guess is right
            System.out.println("You're right! The word was " + word);
        }
    }
    //printing out the hangman dudes
    public static void hangmanDude() {
        if (count == 1) { //first incorrect response
            System.out.println("You're wrong. Try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (count == 2) { //second incorrect response
            System.out.println("Wrong again, Try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 3) { //third incorrect response
            System.out.println("Incorrect answer. try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (count == 4) { //fourth incorrect response
            System.out.println("You're wrong");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /    \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 5) { //fifth incorrect response
            System.out.println("You're wrong");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |        / 69 \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 6) { //sixth incorrect response
                System.out.println("Wrong guess, try again");
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /    \\");
                System.out.println("   |        |     |");
                System.out.println("   |         \\_ _/");
                System.out.println("   |           |");
                System.out.println("   |           |");
                System.out.println("   |          / \\ ");
                System.out.println("___|___      /   \\");
        }
        if (count == 7) { //seventh incorrect response
                System.out.println("GAME OVER!");
                System.out.println("   ____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /    \\");
                System.out.println("   |        |     |");
                System.out.println("   |         \\_ _/");
                System.out.println("   |          _|_");
                System.out.println("   |         / | \\");
                System.out.println("   |          / \\ ");
                System.out.println("___|___      /   \\");
                System.out.println("GAME OVER! The word was " + word);
        }
    }
}