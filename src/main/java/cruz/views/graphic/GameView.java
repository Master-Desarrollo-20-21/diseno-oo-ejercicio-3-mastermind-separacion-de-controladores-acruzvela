package cruz.views.graphic;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import cruz.controllers.ProposalController;
import cruz.controllers.StartController;
import cruz.controllers.ResumeController;
import cruz.models.StateValue;
import cruz.views.Message;

@SuppressWarnings("serial")
public class GameView extends JFrame implements Refresh{
    private String messageSecretCombination="";

    public GameView(){
        this.reset();
    }

    private void reset(){
        this.getContentPane().setLayout(new GridBagLayout());
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void interact(StartController startController){
        for (int i = 0; i < startController.getWidth(); i++) {
			this.messageSecretCombination+=Message.SECRET.getMessage();
        }
        startController.setStateValue(StateValue.IN_GAME);
    }

    public void interact(ProposalController proposalController){
        this.getContentPane().removeAll();
        System.out.println("messageSecretCombination "+this.messageSecretCombination);
        this.getContentPane().add(new SecretCombinationView(this.messageSecretCombination),new Constraints(0,0,3,2));
        this.getContentPane().add(new AttemptView(proposalController, this),new Constraints(0,2,3,13));
        this.setVisible(true);
    }

    @Override
    public void refresh() {
        this.invalidate();
        this.validate();
        this.repaint();
    }

    public void resume(ResumeController resumeController) {
        this.setVisible(false);
        ResumeDialog resumeDialog = new ResumeDialog();
		boolean newGame = resumeDialog.isNewGame();
		if (newGame) {
            resumeController.reset();
            resumeController.play();
		} else {
			System.exit(0);
		}
    }
}
