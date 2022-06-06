package ma.enset.ebankingbackend.exceptions;

public class TransferToTheSameAccountException extends Exception {
    public TransferToTheSameAccountException(String message) {
        super(message);
    }
}