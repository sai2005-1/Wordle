import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Wordle{
    public static void main(String[] args){

        String[] words = new String[]{"ACURA","RURAL","CAROM","CRAIC","SOARE","DUCAT","ERGOT","ZIBEB","TALER","NERPA","POPLE","TARES", "JAZZY", "FUZZY", "JOWLY", "JUNKS", "JUKED","ZILCH","ZIPPO","ZOMBI","BHAJI","CRAZY","DOUBT","ALERT","BEACH","HARRY","EXIST","DRAFT","DOZEN"};

        Random random = new Random();
        int pick = random.nextInt(words.length);

        String original_Word = words[pick];
    Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to a game of Wordle");
        System.out.println();
        System.out.print("Do you want to see the rules of Wordle (y/n): ");
        String ask = sc.nextLine().toLowerCase();
        
        //loop for invalid input
        while(!ask.equals("n")&&!ask.equals("y")){
            System.out.println("Invalid Input");
            System.out.print("Enter 'y' or 'n' to see rules: ");
            ask = sc.nextLine().toLowerCase();
        }

        if(ask.equals("y")){
            rules();
        }

        String[] original = new String[]{" ", " ", " ", " ", " "};

    inputString(original, original_Word);
//number of guesses
    int c = 0;
    String guess_Word="";
    while(!guess_Word.equals(original_Word)&& c<5){
        System.out.println();
        c++;
        System.out.print("Enter your guess "+c+": ");
        guess_Word = sc.nextLine().toUpperCase();

        while(guess_Word.length()>5 || guess_Word.length()<5){
            System.out.println("Invalid length");
            System.out.print("Enter a word which has a length of exactly 5 characters: ");
            guess_Word = sc.nextLine().toUpperCase();
        }
        checkLetters(original, guess_Word, c);
    }
System.out.println();
    if(guess_Word.equals(original_Word)&&c!=1){
        System.out.println("Well Done!!!");
        System.out.println("You guessed the word in "+c+" tries");
    }else if(guess_Word.equals(original_Word)&&c==1){
        System.out.println("You are Lucky!!! or You are a Hacker!!!");
        System.out.println("You guessed the word on your 1st try");
    }else{
        System.out.println("Bad Luck!!!");
        System.out.println("You ran out of your tries");
        System.out.println("The word is '"+original_Word+"'");
    }

    


    }
    public static void rules(){
        System.out.println();
        System.out.println("The rules are simple for wordle: ");
        System.out.println("1) Try to guess the word");
        System.out.println("2) You will be told green or yellow or gray for the letter");
        System.out.println("    - Green --> Right letter at right spot");
        System.out.println("    - Yellow --> The letter is somewhere in the word but not in right spot");
        System.out.println("    - Gray --> The letter is not at all in the word");
        System.out.println("3) The length of the word will be 5 characters");
        System.out.println("4) You will only have 5 guesses to find the word");
        System.out.println();

    }
// fills the original array with letter from original_Word
    public static String[] inputString(String[] original, String original_Word){
        for(int i=0; i<5; i++){
            original[i] = original_Word.substring(i,i+1);
        }
        return original;
    }
    // fills the guess array with letters from guess_Word
    public static String[] inputGuessString(String[] guess, String guess_Word){
        for(int i=0; i<5; i++){
            guess[i] = guess_Word.substring(i,i+1);
        }

        return guess;
    }
     
     public static void checkLetters(String[] original, String guess_Word, int g){
        String[] guess = new String[]{" ", " "," "," "," "};
        inputGuessString(guess, guess_Word);
        ArrayList<String> green = new ArrayList<String>();
        ArrayList<String> yellow = new ArrayList<String>();
        ArrayList<String> gray = new ArrayList<String>();
boolean check = false;
        int x=0;
        while(x<5){
            if(guess[x].equals(original[x])){
                green.add(guess[x]);
                check=true;
            }
            if(!guess[x].equals(original[x])){
                for(int i=0; i<5; i++){
                    if(guess[x].equals(original[i])){
                        yellow.add(guess[x]);
                        check = true;
                    }
                }
            }
            if(check==false){
                gray.add(guess[x]);
            }
            x++;
            check =false;
        }
        System.out.println("Results of guess "+g+": ");
        System.out.println("Green Letters: "+green);
        System.out.println("Yellow Letters: "+yellow);
        System.out.println("Gray Letters: "+gray);



     }

}