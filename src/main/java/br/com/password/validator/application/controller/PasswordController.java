package br.com.password.validator.application.controller;

import br.com.password.validator.application.dto.PasswordDTO;
import br.com.password.validator.application.exception.BusinessException;
import br.com.password.validator.application.service.PasswordService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.HttpURLConnection;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/password")
@Api(tags = "Senhas")
@ApiResponses(value = {
    @ApiResponse(
        code = HttpURLConnection.HTTP_CONFLICT,
        message = "Set in case of business validation error")
})
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping(value = "/verify", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "Verifica se a senha enviada atende aos requisitos mínimos de segurança")
    public ResponseEntity create(
        @RequestBody
        @ApiParam(value = "Objeto contendo a senha a ser validada pelo serviço", required = true, name = "PasswordDTO")
        final PasswordDTO dto) {

        try {
            passwordService.verifyPassword(dto.getPassword());
            return ResponseEntity
                    .ok()
                    .build();
        } catch (BusinessException ex) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(ex.getMessage());
        }

    }

}
