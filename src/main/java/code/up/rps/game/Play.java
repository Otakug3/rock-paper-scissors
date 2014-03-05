package code.up.rps.game;

import code.up.rps.choices.Choice;
import code.up.rps.choices.Paper;
import code.up.rps.choices.Rock;
import code.up.rps.choices.Scissors;
import java.util.Scanner;

/**
 * 
 * @author Peter C
 */
public class Play {
    
    private static final Scanner readInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("_________________________________");
        System.out.println("");
        System.out.println("");
        System.out.println("Your Go - pick Rock, Paper or Scissors:");
        
        String playersChoice = readInput.nextLine();
        System.out.println("You picked "+ playersChoice);
        
        try {
            Choice playersRealChoice = parse(playersChoice);
            
        } catch (IllegalArgumentException ex) {
            System.out.println("Sorry, that doesn't make any sense.");
        }
    }
    
    private static Choice parse(String playersChoice){
        if (playersChoice.equalsIgnoreCase("rock")){
            return new Rock();
        } else if (playersChoice.equalsIgnoreCase("scissors")){
            return new Scissors();
        } else if (playersChoice.equalsIgnoreCase("paper")){
            return new Paper();
        }
        throw new IllegalArgumentException("I don't understand what you said. Silly you.");
    }
}
