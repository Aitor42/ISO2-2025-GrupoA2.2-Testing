package parser;

import exception.InputException;

public class BooleanParser implements ValueParser<Boolean> {
    @Override
    public Boolean parse(String input) throws InputException {
        String normalized = input.trim().toLowerCase();
        if (normalized.equals("true") || normalized.equals("yes") || normalized.equals("y")) {
            return true;
        } else if (normalized.equals("false") || normalized.equals("no") || normalized.equals("n")) {
            return false;
        } else {
            throw new InputException("Invalid boolean. Please enter 'yes' or 'no'.");
        }
    }
}
