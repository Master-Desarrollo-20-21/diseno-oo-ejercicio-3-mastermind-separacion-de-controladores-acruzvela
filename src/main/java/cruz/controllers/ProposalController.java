package cruz.controllers;

import cruz.models.Game;
import cruz.models.ProposedCombination;
import cruz.models.Attempt;
import cruz.types.Error;
import cruz.models.Result;
import cruz.models.State;
import cruz.Initial;

public class ProposalController extends Controller {
    private ProposedCombination proposedCombination;
    
    public ProposalController(Game game, State state, Initial initial) {
		super(game, state, initial);
	}

    public Error check(String proposedString){
        this.proposedCombination=new ProposedCombination();
        for (Error erroItem: Error.values()) {
            Error error=proposedCombination.getVALIDATORS().get(erroItem).isValid(proposedCombination, proposedString);
            if (!error.isNull()) {
                return error;
            }
        }
        return Error.NULL_ERROR;
    }

    public void createAttempt(String proposedString){
        this.proposedCombination=new ProposedCombination();
        this.proposedCombination.createCombination(proposedString);
        Result result = game.getSecretCombination().evalueCombination(proposedCombination);
        Attempt attempt=new Attempt(proposedCombination,result);
        this.game.addAttempt(attempt);
    }

    public int getAttemptsSize(){
        return game.getAttemptsSize();
    }

    public String getProposedCombinationString(int position){
        return game.getAttempts().get(position).getProposedCombination().toString();
    }

    public int getBlacks(int position){
        return game.getAttempts().get(position).getBlacks();
    }

    public int getWhites(int position){
        return game.getAttempts().get(position).getWhites();
    }

    public boolean haveMoreAttempts() {
          return !game.isWinner() && this.game.getAttemptsSize() < Game.ATTEMPTS_NUMBER;
    }

    public boolean isWinner(){
        return game.isWinner();
    }

    public String getSecretCombinationString(){
        return this.game.getSecretCombination().toString();
    }

    public int getNumberAttempts(){
        return this.game.getAttemptsSize();
    }

    public void next(){
        this.state.next();
    }

    public void reset(){
        this.game.reset();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
