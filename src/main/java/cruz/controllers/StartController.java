package cruz.controllers;

import cruz.models.Game;
import cruz.models.State;
import cruz.Initial;

public class StartController extends Controller {
  public StartController(Game game, State state, Initial initial) {
    super(game, state, initial);
  }
    
  public void start() {
    this.state.next();
  }

  @Override
  public void accept(ControllersVisitor controllersVisitor) {
    controllersVisitor.visit(this);
  }
}
