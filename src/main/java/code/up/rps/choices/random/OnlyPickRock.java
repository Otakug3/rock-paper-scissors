package code.up.rps.choices.random;

import code.up.rps.choices.Choice;
import code.up.rps.choices.Rock;

/**
 *
 * @author Peter C
 */
public class OnlyPickRock implements RandomChoice {

    public Choice randomChoice(Choice playersChoice) {
        return new Rock();
    }

}
