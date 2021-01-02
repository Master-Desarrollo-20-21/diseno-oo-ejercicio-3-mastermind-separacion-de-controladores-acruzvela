package cruz.models;

import cruz.types.Error;

public interface Validator {
    Error isValid(ProposedCombination proposedCombination, String proposedString);
}
