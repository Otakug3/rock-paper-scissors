package code.up.rps.choices.parser;

import code.up.rps.choices.Choice;
import code.up.rps.choices.Paper;
import code.up.rps.choices.Rock;
import code.up.rps.choices.Scissors;

/**
 *
 * @author Peter C
 */
public class DefaultParser implements ChoiceParser {
    
    @Override
    public Choice parse(String input){
        if (input.equalsIgnoreCase(java.util.ResourceBundle.getBundle("Bundle").getString("ROCK"))) {
            return new Rock();
        } else if (input.equalsIgnoreCase(java.util.ResourceBundle.getBundle("Bundle").getString("SCISSORS"))) {
            return new Scissors();
        } else if (input.equalsIgnoreCase(java.util.ResourceBundle.getBundle("Bundle").getString("PAPER"))) {
            return new Paper();
        }
        throw new IllegalArgumentException(java.util.ResourceBundle.getBundle("Bundle").getString("I DON'T UNDERSTAND WHAT YOU SAID. SILLY YOU."));
    }
}
