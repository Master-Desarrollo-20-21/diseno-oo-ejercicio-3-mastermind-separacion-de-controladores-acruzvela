package cruz.views.graphic;

import cruz.controllers.ProposalController;
import cruz.controllers.StartController;
import cruz.controllers.ResumeController;
import cruz.views.View;

public class GraphicView extends View {
    private GameView gameView;

    public GraphicView(){
        gameView=new GameView();
    }

    public void visit(StartController startController) {
		  this.gameView.interact(startController);
	  }
	
	  public void visit(ProposalController proposalController) {
		  this.gameView.interact(proposalController);
    }
    
    public void visit(ResumeController resumeController) {
		  this.gameView.resume(resumeController);
	  }

}
