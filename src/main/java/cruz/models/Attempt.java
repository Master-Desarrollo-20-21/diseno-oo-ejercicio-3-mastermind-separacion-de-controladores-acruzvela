package cruz.models;

public class Attempt {
    private ProposedCombination proposedCombination;
	private Result result;

	public Attempt(ProposedCombination proposedCombination, Result result) {
		this.proposedCombination = proposedCombination;
		this.result = result;
	}

	public boolean isWinner() {
		return this.result.getBlacks() == 4;
	}

	public ProposedCombination getProposedCombination(){
		return this.proposedCombination;
	}

	public Result getResult(){
		return this.result;
	}

	public int getBlacks(){
		return this.result.getBlacks();
	}

	public int getWhites(){
		return this.result.getWhites();
	}
}
