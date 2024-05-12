package ru.example;

public class WrongPasswordException extends RuntimeException {
    private int currentLength;
    private boolean matchConfirm;

    public WrongPasswordException(int currentLength, boolean matchConfirm) {
        super();
        this.currentLength = currentLength;
        this.matchConfirm = matchConfirm;
    }

    @Override
    public String getMessage() {
        boolean badlen = currentLength <= 20;
        return String.format("Your password is of %scorrect length%s %d. Password %smatch the confirmation.",
                ((badlen) ? "in" : ""),
                ((badlen) ? ", expected > 20, given" : ","),
                currentLength,
                (matchConfirm) ? "" : "doesn't ");
    }
}