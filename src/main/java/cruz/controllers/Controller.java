package cruz.controllers;

import cruz.models.State;

import cruz.models.Game;
import cruz.Initial;
import cruz.models.StateValue;

public abstract class Controller {
    protected Game game;
	protected State state;
	protected Initial initial;

	Controller(Game game, State state, Initial initial) {
		this.game = game;
		this.state = state;
		this.initial=initial;
	}

	public abstract void accept(ControllersVisitor controllersVisitor);

	public int getNumberAttempts(){
        return this.game.getAttemptsSize();
	}
	
	public void setStateValue(StateValue stateValue){
		this.state.setStateValue(stateValue);
		this.initial.play();
	}
	
	public int getWidth(){
		return this.game.getWidth();
	}
}
