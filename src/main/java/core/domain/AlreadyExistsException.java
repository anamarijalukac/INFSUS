package core.domain;

public class AlreadyExistsException extends DomainException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
