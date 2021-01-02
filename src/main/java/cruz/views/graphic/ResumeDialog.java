package cruz.views.graphic;

import javax.swing.JOptionPane;
import cruz.views.Message;

public class ResumeDialog {
    private boolean newGame;

	public ResumeDialog() {
		this.newGame = (JOptionPane.showConfirmDialog(null, Message.RESUME.getMessage(),
				Message.TITLE.getMessage(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
	}

	boolean isNewGame() {
		return this.newGame;
	}
}
