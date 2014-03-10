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
        if (input.equalsIgnoreCase("rock")) {
            return new Rock();
        } else if (input.equalsIgnoreCase("scissors")) {
            return new Scissors();
        } else if (input.equalsIgnoreCase("paper")) {
            return new Paper();
        }
        throw new IllegalArgumentException("I don't understand what you said. Silly you.");
    }
}
