package cruz.views.graphic;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import cruz.views.ErrorView;
import cruz.views.Message;
import cruz.controllers.ProposalController;
import cruz.models.StateValue;
import cruz.types.Error;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ProposedCombinationView extends JPanel implements ActionListener {
    private Refresh refresh;
    private JTextField proposedCombinationTextField;
    private JButton proposedCombinationButton;
    private String proposedString;
    private AddAttempt addAttempt;
    private ProposalController proposalController;

    public ProposedCombinationView(ProposalController proposalController, Refresh refresh, AddAttempt addAttempt) {
        this.proposalController=proposalController;
        this.refresh=refresh;
        this.addAttempt=addAttempt;
        init();
    }

    private void init(){
        this.setLayout(new GridBagLayout());
        this.add(new JLabel(Message.PROPOSED_COMBINATION.getMessage()), new Constraints(0, 0, 3, 1));
        proposedCombinationTextField = new JTextField();
        this.add(proposedCombinationTextField, new Constraints(0, 1, 3, 1));
        proposedCombinationButton = new JButton(Message.OK.getMessage());
        this.add(proposedCombinationButton, new Constraints(0, 2, 3, 1));
        this.proposedCombinationButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        read();
    }

    private void read(){
        this.proposedString = this.proposedCombinationTextField.getText();
        this.proposedCombinationTextField.setText("");
        Error error=this.proposalController.check(proposedString);
        if(!error.isNull()){
            new ErrorView(error).showMessage();
        }
        if(error.isNull()){
            this.proposalController.createAttempt(proposedString);
            printAttempts();
            if (!this.haveMoreAttempts()){
                this.finish();
            }
        }
    }

    private void printAttempts(){
        this.addAttempt.removeAll();
        for (int i=0;i<this.proposalController.getAttemptsSize();i++){
            this.addAttempt.add(i+1,
            this.proposalController.getProposedCombinationString(i),
            this.proposalController.getBlacks(i), this.proposalController.getWhites(i) );
        }
        this.refresh.refresh();
    }

    public boolean haveMoreAttempts() {
        return this.proposalController.haveMoreAttempts();
    }

    private void finish(){
        if(this.proposalController.isWinner()) {
            JOptionPane.showMessageDialog(null,Message.WINNER.getMessage());
        }else {
            JOptionPane.showMessageDialog(null,Message.LOSER.getMessage("#secretcombination",this.proposalController.getSecretCombinationString()));
        }
        this.proposalController.setStateValue(StateValue.FINAL);
    }

}
