package cruz;

import cruz.controllers.Logic;
import cruz.views.MastermindView;

/**
 * Hello world!
 *
 */
public abstract class Mastermind implements Initial
{
    protected Logic logic;
	protected MastermindView mastermindView;

    protected Mastermind() {
        this.logic = new Logic(this);
		this.mastermindView = this.createView();
    }
    
    protected abstract MastermindView createView();
  
    public abstract void play();
    
    public static void main(String[] args) {
          if(args[0].equals("console")){
              new ConsoleMastermind().play();
          }
          else if (args[0].equals("graphic")){
              new GraphicMastermind().play();
          }
    }
}
