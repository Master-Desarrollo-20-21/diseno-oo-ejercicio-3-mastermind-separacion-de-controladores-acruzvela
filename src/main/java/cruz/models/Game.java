package cruz.models;

import java.util.ArrayList;

public class Game {
    public static final int ATTEMPTS_NUMBER=10;
    private SecretCombination secretCombination;
    private ArrayList<Attempt> attempts;

    public Game(){
        this.reset();
    }

    public void reset(){
        secretCombination=new SecretCombination();
        attempts=new ArrayList<Attempt>();
    }

    public void addAttempt(Attempt attempt){
      attempts.add(attempt);
    }

    public Attempt lastAttempt() {
      return this.attempts.get(attempts.size()-1);
    }

    public ArrayList<Attempt> getAttempts(){
      return this.attempts;
    }

    public SecretCombination getSecretCombination(){
      return this.secretCombination;
    }

    public int getAttemptsSize(){
      return this.attempts.size();
    }

    public boolean isWinner(){
      return this.lastAttempt().isWinner();
    }

    public int getWidth(){
      return this.secretCombination.getWidth();
    }
}
