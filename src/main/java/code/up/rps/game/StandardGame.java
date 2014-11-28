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
        log.info(java.util.ResourceBundle.getBundle("Bundle").getString("YOUR GO - PICK ROCK, PAPER OR SCISSORS:"));
        String playersChoice = readInput.nextLine();
        log.info(java.text.MessageFormat.format(java.util.ResourceBundle.getBundle("Bundle").getString("YOU PICKED {0}"), new Object[] {playersChoice}));

        try {
            Choice playersRealChoice = parser.parse(playersChoice);
            Choice computersChoice = randomChoice.randomChoice(playersRealChoice);

            log.info(java.text.MessageFormat.format(java.util.ResourceBundle.getBundle("Bundle").getString("THE COMPUTER PICKED {0}"), new Object[] {computersChoice.getName()}));

            Result result = playersRealChoice.seeTheResult(computersChoice);

            if (result.equals(Result.WIN)) {
                log.info(java.util.ResourceBundle.getBundle("Bundle").getString("CONGRATULATIONS YOU WON!!!!!!"));
            } else if (result.equals(Result.TIE)) {
                log.info(java.util.ResourceBundle.getBundle("Bundle").getString("OH IT'S A TIE... BEST OF THREE?"));
            } else if (result.equals(Result.LOSE)) {
                log.info(java.util.ResourceBundle.getBundle("Bundle").getString("YOU SUCK. I WIN HAHAHAH."));
            }
        } catch (IllegalArgumentException ex) {
            log.error(java.util.ResourceBundle.getBundle("Bundle").getString("SORRY, THAT DOESN'T MAKE ANY SENSE."));
        } catch (Exception ex) {
            log.error(java.util.ResourceBundle.getBundle("Bundle").getString("RANDOM ERROR HAPPENED."), ex);
            
        }
    }
    
}
