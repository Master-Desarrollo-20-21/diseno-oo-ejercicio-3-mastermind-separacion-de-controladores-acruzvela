package cruz.views.console;

import cruz.controllers.Controller;
import cruz.utils.Console;
import cruz.views.Message;

public class SecretCombinationView {
    private Controller controller;
	
	SecretCombinationView(Controller controller) {
		this.controller = controller;
	}
	
	void writeln() {
        Console console=new Console();
        String messageSecretCombination="";
		for (int i = 0; i < this.controller.getWidth(); i++) {
			messageSecretCombination+=Message.SECRET.getMessage();
        }
        console.write(messageSecretCombination);
	}
}
