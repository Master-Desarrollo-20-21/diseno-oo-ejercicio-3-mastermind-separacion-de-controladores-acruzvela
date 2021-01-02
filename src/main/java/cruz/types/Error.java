
package cruz.types;

public enum Error {
	LENGTH,
	WRONG_COLOR,
	REPEATED_COLOR,
    NULL_ERROR;

    public boolean isNull() {
		return this == Error.NULL_ERROR;
	}
}