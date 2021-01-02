package cruz.controllers;

import cruz.models.Game;
import cruz.models.State;
import cruz.Initial;

public class ResumeController extends Controller {
    public ResumeController(Game game, State state, Initial initial) {
		super(game, state, initial);
	}
    
    public void reset(){
        this.game.reset();
        this.state.reset();
	}
	
	public void play(){
		this.initial.play();
	}

    public void resume(boolean newGame) {
		if (newGame) {
			this.reset();
		} else {
			this.state.next();
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}
