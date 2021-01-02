package cruz.views.console;

import cruz.controllers.ProposalController;
import cruz.controllers.ResumeController;
import cruz.controllers.StartController;
import cruz.views.View;

public class ConsoleView extends View {
    private StartView startView;
	private ProposalView proposalView;
	private ResumeView resumeView;

    public ConsoleView() {
		this.startView = new StartView();
		this.proposalView = new ProposalView();
		this.resumeView = new ResumeView();
	}

	public void visit(StartController startController) {
		this.startView.interact(startController);		
	}
	
	public void visit(ProposalController proposalController) {
		this.proposalView.interact(proposalController);
	}
	
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}
}
