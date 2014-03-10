package code.up.rps.game;

import code.up.rps.choices.Choice;
import code.up.rps.choices.Result;
import code.up.rps.choices.parser.ChoiceParser;
import code.up.rps.choices.random.RandomChoice;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Peter C
 */
public class StandardGame implements Game {

    private static final Logger log = LoggerFactory.getLogger(StandardGame.class);
    
    private final Scanner readInput = new Scanner(System.in);
    private final ChoiceParser parser;
    private final RandomChoice randomChoice;

    public StandardGame(ChoiceParser parser, RandomChoice randomChoice) {
        this.parser = parser;
        this.randomChoice = randomChoice;
    }
    
    @Override
    public void play() {
        log.info("Your Go - pick Rock, Paper or Scissors:");
        String playersChoice = readInput.nextLine();
        log.info("You picked " + playersChoice);

        try {
            Choice playersRealChoice = parser.parse(playersChoice);
            Choice computersChoice = randomChoice.randomChoice(playersRealChoice);

            log.info("The computer picked " + computersChoice.getName());

            Result result = playersRealChoice.seeTheResult(computersChoice);

            if (result.equals(Result.WIN)) {
                log.info("CONGRATULATIONS YOU WON!!!!!!");
            } else if (result.equals(Result.TIE)) {
                log.info("Oh it's a tie... best of three?");
            } else if (result.equals(Result.LOSE)) {
                log.info("You suck. I win hahahah.");
            }
        } catch (IllegalArgumentException ex) {
            log.error("Sorry, that doesn't make any sense.");
        } catch (Exception ex) {
            log.error("Random error happened.", ex);
        }
    }
    
}
