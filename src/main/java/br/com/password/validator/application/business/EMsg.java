package br.com.password.validator.application.business;

public enum EMsg {

    UNSAFE_PASSWORD("msg.0001");

    private final String codeMessage;

    EMsg(final String codeMessage) {
        this.codeMessage = codeMessage;
    }

    public String getCodeMessage() {
        return codeMessage;
    }
}
