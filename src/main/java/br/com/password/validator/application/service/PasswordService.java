package br.com.password.validator.application.service;

import br.com.password.validator.application.business.Rule0001;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    @Autowired
    private Rule0001 rule0001;

    public void verifyPassword(final String password) {
        rule0001.execute(password);
    }

}
