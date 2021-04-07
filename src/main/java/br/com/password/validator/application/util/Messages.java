package br.com.password.validator.application.component;

import br.com.password.validator.application.business.EMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Messages {

    @Autowired
    private MessageSource messageSource;

    public String from(final EMsg code) {
        return messageSource.getMessage(code.getCodeMessage(), null, Locale.getDefault());
    }

}
