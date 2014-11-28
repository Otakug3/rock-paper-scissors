package code.up.rps.choices;

/**
 *
 * @author Peter C
 */
public class Rock implements Choice {

    @Override
    public Result seeTheResult(Choice choice) {
        if (choice instanceof Scissors){
            return Result.WIN;
        } else if (choice instanceof Rock){
            return Result.TIE;
        }
        
        return Result.LOSE;
    }
    
    @Override
    public String getName(){
        return java.util.ResourceBundle.getBundle("Bundle").getString("ROCK");
    }
}