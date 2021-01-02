package cruz.views.console;

import cruz.controllers.StartController;
import cruz.views.Message;
import cruz.utils.Console;

public class StartView {

    private SecretCombinationView secretCombinationView;

    void interact(StartController startController) {
        startController.start();
        Message.TITLE.write();
        this.secretCombinationView = new SecretCombinationView(startController);
        this.secretCombinationView.writeln();
        new Console().write("");
    }
}
