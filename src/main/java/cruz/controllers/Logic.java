package cruz.controllers;

import java.util.HashMap;
import java.util.Map;
import cruz.models.Game;
import cruz.models.State;
import cruz.models.StateValue;
import cruz.Initial;

public class Logic {
    private State state;
    private Game game;

    private Map<StateValue, Controller> controllers;
		
	public Logic(Initial initial) {
		this.state = new State();
		this.game = new Game();
		this.controllers = new HashMap<StateValue, Controller>();
		this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state, initial));
		this.controllers.put(StateValue.IN_GAME, new ProposalController(this.game, this.state, initial));
		this.controllers.put(StateValue.FINAL, new ResumeController(this.game, this.state, initial));
		this.controllers.put(StateValue.EXIT, null);
	}
	
	public Controller getController() {
		return this.controllers.get(this.state.getValueState());
	}
}
