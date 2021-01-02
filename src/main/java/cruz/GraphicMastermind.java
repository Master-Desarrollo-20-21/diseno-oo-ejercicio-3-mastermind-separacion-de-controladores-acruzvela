package cruz;

import cruz.views.MastermindView;
import cruz.views.graphic.GraphicView;
import cruz.controllers.Controller;

public class GraphicMastermind extends Mastermind {
    @Override
    protected MastermindView createView() {
        return new GraphicView();
    }

    public void play() {
        Controller controller;
        controller = this.logic.getController();
        this.mastermindView.interact(controller);
    }
}
