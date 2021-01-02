package cruz.views.console;

import cruz.controllers.ProposalController;

public class AttemptView {
    private ProposalController proposalController;

    public AttemptView(ProposalController proposalController){
        this.proposalController=proposalController;
    }

    public void interact() {
        ProposedCombinationView proposedCombinationView=new ProposedCombinationView(proposalController);
        String proposedString = proposedCombinationView.read();
        proposalController.createAttempt(proposedString);
    }
}
