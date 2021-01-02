package cruz.views;

import cruz.controllers.ControllersVisitor;
import cruz.controllers.Controller;

public abstract class View implements MastermindView, ControllersVisitor{
    public void interact(Controller controller) {
		controller.accept(this);
	}
}
