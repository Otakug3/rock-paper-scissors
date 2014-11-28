package code.up.rps.choices;

/**
 *
 * @author Peter C
 */
public class Scissors implements Choice {

    @Override
    public Result seeTheResult(Choice choice) {
        if (choice instanceof Paper){
            return Result.WIN;
        } else if (choice instanceof Scissors){
            return Result.TIE;
        }
        
        return Result.LOSE;
    }
    
    @Override
    public String getName(){
        return java.util.ResourceBundle.getBundle("Bundle").getString("SCISSORS");
    }
}
