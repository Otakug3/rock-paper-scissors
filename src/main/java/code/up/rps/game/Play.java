package code.up.rps.game;

import code.up.rps.choices.Paper;
import code.up.rps.choices.Rock;
import code.up.rps.choices.Scissors;
import code.up.rps.choices.parser.ChoiceParser;
import code.up.rps.choices.parser.DefaultParser;
import code.up.rps.choices.random.FairRandomChoice;
import code.up.rps.choices.random.RandomChoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Peter C
 */
public class Play {

    private static final Logger log = LoggerFactory.getLogger(Play.class);

    public static void main(String[] args) {
        log.info("Welcome to Rock, Paper, Scissors!");
        log.info("_________________________________");
        log.info("");
        log.info("");
        
        ChoiceParser parser = new DefaultParser();
        RandomChoice randomGenerator = new FairRandomChoice(new Rock(), new Paper(), new Scissors());
        Game game = new StandardGame(parser, randomGenerator);
        
        while (true){
            game.play();
        }
    }
}