package code.up.rps.choices.random;

import code.up.rps.choices.Choice;
import code.up.rps.choices.Paper;
import code.up.rps.choices.Result;
import code.up.rps.choices.Rock;
import code.up.rps.choices.Scissors;

/**
 *
 * @author Peter C
 */
public class CheatingRandomChoice implements RandomChoice {

    public Choice randomChoice(Choice playersChoice) {
        Rock rock = new Rock();
        Result result = rock.seeTheResult(playersChoice);
        if (result.equals(Result.WIN)){
            return rock;
        }
        
        Paper paper = new Paper();
        result = paper.seeTheResult(playersChoice);
        if (result.equals(Result.WIN)){
            return paper;
        }
        
        return new Scissors();
    }
    
    
}
