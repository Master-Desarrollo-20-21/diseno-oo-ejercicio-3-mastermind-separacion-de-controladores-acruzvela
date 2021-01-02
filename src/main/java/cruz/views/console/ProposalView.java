package cruz.views.console;

import cruz.controllers.ProposalController;
import cruz.views.Message;
import cruz.utils.Console;

public class ProposalView {
    void interact(ProposalController proposalController){
        printHeadAttempts(proposalController);
        AttemptView attemptView=new AttemptView(proposalController);
        attemptView.interact();
        printAttempts(proposalController);
        if (!haveMoreAttempts(proposalController)){
            proposalController.next();
            finish(proposalController);
        }
    }

    private void printHeadAttempts(ProposalController proposalController){
        Message.ATTEMPTS.write(proposalController.getNumberAttempts());
        SecretCombinationView secretCombinationView = new SecretCombinationView(proposalController);
        secretCombinationView.writeln();
    }

    private void printAttempts(ProposalController proposalController) {
        Console console=new Console();
        for (int i=0;i<proposalController.getAttemptsSize();i++){
            Message.RESULT.write(proposalController.getProposedCombinationString(i),
            proposalController.getBlacks(i),proposalController.getWhites(i));
        }
        console.write("\n");
      }

      public boolean haveMoreAttempts(ProposalController proposalController) {
            return proposalController.haveMoreAttempts();
      }

      private void finish(ProposalController proposalController){
        if(proposalController.isWinner()) {
            Message.WINNER.write();
        }else {
            Message.LOSER.write("#secretcombination",proposalController.getSecretCombinationString());
        }
    }
}
