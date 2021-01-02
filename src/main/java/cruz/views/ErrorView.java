package cruz.views;

import cruz.utils.Console;
import cruz.types.Error;
import javax.swing.JOptionPane;
import cruz.types.Color;

public class ErrorView {
	private static final String[] MESSAGES = { "Wrong proposed combination length",
			"Wrong colors they must be: " + Color.getAvailableColors(), "Wrong proposed, can not repeat color." };

	private Error error;

	public ErrorView() {
	}

	public ErrorView(Error error) {
		this.error = error;
	}

	public void writeln() {
		if (!this.error.isNull()) {
			new Console().write(ErrorView.MESSAGES[this.error.ordinal()] + "\n");
		}
	}

	public void showMessage() {
		if (!this.error.isNull()) {
			JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[this.error.ordinal()]);
		}
	}
}
