package cruz.views.graphic;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import cruz.controllers.ProposalController;
import cruz.views.Message;

@SuppressWarnings("serial")
public class AttemptView extends JPanel implements AddAttempt{
	private ProposalController proposalController;
	private Refresh refresh;
	private JPanel attemptPanel;

	public AttemptView(ProposalController proposalController, Refresh refresh) {
		this.proposalController=proposalController;
		this.refresh=refresh;
		this.attemptPanel= new JPanel();
		this.attemptPanel.setLayout(new GridBagLayout());
		init();
	}	

	public void init(){
		this.setLayout(new GridBagLayout());
		this.add(this.attemptPanel, new Constraints(0, 0, 3, 10));
		this.add(new ProposedCombinationView(this.proposalController, refresh, this),new Constraints(0, 10, 3, 3));
	}

	@Override
	public void add(int numAttempt, String proposalCombinationString, int blacks, int whites) {
		this.attemptPanel.add(new JLabel(Message.ATTEMPTS.getMessage(numAttempt)+Message.RESULT.getMessage(proposalCombinationString,
		blacks,whites)),new Constraints(0,numAttempt,3,1));
	}

	public void removeAll(){
		this.attemptPanel.removeAll();
	}
}
