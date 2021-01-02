package cruz;

import cruz.views.MastermindView;
import cruz.views.console.ConsoleView;
import cruz.controllers.Controller;

public class ConsoleMastermind extends Mastermind {
    @Override
    protected MastermindView createView() {
        return new ConsoleView();
    }

    public void play() {
        Controller controller;
        controller = this.logic.getController();
        do {
            this.mastermindView.interact(controller);
            controller = this.logic.getController();
        } while (controller != null);
    }

}
