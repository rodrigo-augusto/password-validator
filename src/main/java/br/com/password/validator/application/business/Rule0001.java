package br.com.password.validator.application.business;

import br.com.password.validator.application.util.Messages;
import br.com.password.validator.application.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Considerar uma senha sendo válida quando a mesma possuir as seguintes definições:
 * <ul>
 * <li> Nove ou mais caracteres
 * <li> Ao menos 1 dígito
 * <li> Ao menos 1 letra minúscula
 * <li> Ao menos 1 letra maiúscula
 * <li> Ao menos 1 caractere especial
 * <li> Não possuir caracteres repetidos dentro do conjunto
 * </ul>
 * <p>
 * Nota: Espaços em branco não devem ser considerados como caracteres válidos.
 *
 * @author rodrigo.amaral
 */
@Component
public class Rule0001 {

    @Value("${special.caracters}")
    private String especialCaracters;

    @Autowired
    private Messages messages;

    public void execute(final String password) {
        Optional
            .ofNullable(password)
            .filter(str -> str.length() >= 9)
            .filter(str -> str.matches(".*[0-9].*"))
            .filter(str -> str.matches(".*[A-Z].*"))
            .filter(str -> str.matches(".*[a-z].*"))
            .filter(str -> str.matches(".*[" + especialCaracters + "].*"))
            .filter(str -> str.length() == str.chars().distinct().count())
            .filter(str -> !str.contains(" "))
            .orElseThrow(() -> new BusinessException(messages.from(EMsg.UNSAFE_PASSWORD)));
    }

}
