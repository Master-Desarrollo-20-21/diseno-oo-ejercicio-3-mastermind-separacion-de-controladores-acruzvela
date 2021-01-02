package cruz.views.console;

import cruz.controllers.ResumeController;
import cruz.utils.Console;
import cruz.views.Message;

public class ResumeView {
    void interact(ResumeController resumeController) {
        resumeController.resume(this.resume());
    }

    private boolean resume() {
        String answer;
        do{
            answer = new Console().read(Message.RESUME.getMessage());
        } while(!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));
        return answer.equalsIgnoreCase("Y");
    }
}
