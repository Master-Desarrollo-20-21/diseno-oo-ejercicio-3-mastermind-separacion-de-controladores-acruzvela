package cruz.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.Collections;
import cruz.types.Error;
import cruz.types.Color;

public class ProposedCombination extends Combination {
    private static final Map<Error, Validator> VALIDATORS;

    static {
        final Map<Error, Validator> validators = new HashMap<>();
        validators.put(Error.LENGTH, new Validator() {
            @Override
            public Error isValid(ProposedCombination proposedCombination, String proposedString){
                return proposedCombination.isValidLength(proposedString);
            }
        });
        validators.put(Error.WRONG_COLOR, new Validator() {
            @Override
            public Error isValid(ProposedCombination proposedCombination, String proposedString){
                return proposedCombination.isValidColor(proposedString);
            }
        });
        validators.put(Error.REPEATED_COLOR, new Validator() {
            @Override
            public Error isValid(ProposedCombination proposedCombination, String proposedString){
                return proposedCombination.isNotRepeatedColor(proposedString);
            }
        });
        validators.put(Error.NULL_ERROR, new Validator() {
            @Override
            public Error isValid(ProposedCombination proposedCombination, String proposedString){
                return Error.NULL_ERROR;
            }
        });
    
        VALIDATORS = Collections.unmodifiableMap(validators);
    }

    public Error isValidLength(String proposedString) {
        return proposedString.length()==this.LENGTH?
                Error.NULL_ERROR:Error.LENGTH;
    }

    public Error isValidColor(String proposedString) {
        String[] proposedArray = proposedString.split("");
        for (String item : proposedArray) {
            if(!Color.getAvailableColors().contains(item)){
                return Error.WRONG_COLOR;
            }
        }
		return Error.NULL_ERROR;
    }

    public Error isNotRepeatedColor(String proposedString) {
        Set<Character> chars = new HashSet<Character>();
        for (char c : proposedString.toCharArray()) {
            if (!chars.add(c)) return Error.REPEATED_COLOR;
        }
        return Error.NULL_ERROR;
    }

    public Map<Error, Validator> getVALIDATORS(){
        return VALIDATORS;
    }
}
