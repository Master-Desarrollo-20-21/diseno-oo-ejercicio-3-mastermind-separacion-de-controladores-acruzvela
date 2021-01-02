package cruz.views.console;

import cruz.controllers.ProposalController;
import cruz.types.Color;
import cruz.types.Error;
import cruz.utils.Console;
import cruz.views.ErrorView;
import cruz.views.Message;

public class ProposedCombinationView{
    private ProposalController proposalController;

	ProposedCombinationView(ProposalController proposalController) {
		this.proposalController = proposalController;
    }

    public String read() {
        String proposedString;
        Console console=new Console();
        Error error;
		do {
            Message.ALLOWED_COLORS.write("#allowedcolors",Color.getAvailableColors());
            proposedString=console.read(Message.PROPOSED_COMBINATION.getMessage());
            error=this.proposalController.check(proposedString);
            if(!error.isNull()){
                new ErrorView(error).writeln();
            }
        }while(!error.isNull());
        return proposedString;
    }
}
