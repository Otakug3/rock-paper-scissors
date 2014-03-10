package code.up.rps.choices.random;

import code.up.rps.choices.Choice;
import java.util.Random;

/**
 *
 * @author Peter C
 */
public class FairRandomChoice implements RandomChoice {
    
    private final Choice[] possibleChoices;

    public FairRandomChoice(Choice... possibleChoices) {
        this.possibleChoices = possibleChoices;
    }

    public Choice randomChoice(Choice playersChoice) {
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(possibleChoices.length); // Random number nextInt starts at 0 and goes to < number you put in.

        Choice computerChoice = possibleChoices[randomIndex];
        return computerChoice;
    }
}
