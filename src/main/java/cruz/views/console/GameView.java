package cruz.views.console;

import cruz.controllers.ProposalController;
import cruz.controllers.StartController;
import cruz.utils.Console;
import cruz.views.Message;

public class GameView {
    private StartController startController;
    private ProposalController proposalController;
    private AttemptView attemptView;

    public GameView(StartController startController, ProposalController proposalController){
        this.startController=startController;
        this.proposalController=proposalController;
        attemptView=new AttemptView(this.proposalController);
    }

    public void interact() {
        Message.TITLE.write();
        do {
            printHeadAttempts();
            this.attemptView.interact();
            printAttempts();
        }while(haveMoreAttempts());
        finish();
    }

    private void printHeadAttempts(){
      Message.ATTEMPTS.write(this.startController.getNumberAttempts());
      Message.SECRET_COMBINATION.write();
    }

    private void printAttempts() {
        Console console=new Console();
        for (int i=0;i<proposalController.getAttemptsSize();i++){
            Message.RESULT.write(proposalController.getProposedCombinationString(i),
            proposalController.getBlacks(i),proposalController.getWhites(i));
        }
        console.write("\n");
      }

    public boolean haveMoreAttempts() {
      return proposalController.haveMoreAttempts();
    }
  
    private void finish(){
        if(proposalController.isWinner()) {
            Message.WINNER.write();
        }else {
            Message.LOSER.write("#secretcombination",this.proposalController.getSecretCombinationString());
        }
    }
}