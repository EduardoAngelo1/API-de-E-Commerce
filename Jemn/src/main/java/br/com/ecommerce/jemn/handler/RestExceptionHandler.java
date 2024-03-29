package br.com.ecommerce.jemn.handler;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import br.com.ecommerce.jemn.common.ConversorData;
import br.com.ecommerce.jemn.model.error.ErrorResposta;
import br.com.ecommerce.jemn.model.exceptions.ResourceBadRequestException;
import br.com.ecommerce.jemn.model.exceptions.ResourceConflict;
import br.com.ecommerce.jemn.model.exceptions.ResourceNotFoundException;
import br.com.ecommerce.jemn.model.exceptions.ResourceUnprocessableEntity;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResposta> handlerResourceNotFoundException(ResourceNotFoundException ex){

        String data = ConversorData.converterDateParaDataHora(new Date());

        ErrorResposta erro = new ErrorResposta(404, "Not Found", ex.getMessage(), data);

        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ErrorResposta> handlerResourceBadRequestException(ResourceBadRequestException ex){

        String data = ConversorData.converterDateParaDataHora(new Date());

        ErrorResposta erro = new ErrorResposta(400, "Bad Request", ex.getMessage(), data);

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResposta> handlerException(Exception ex){

        String data = ConversorData.converterDateParaDataHora(new Date());

        ErrorResposta erro = new ErrorResposta(500, "Internal Server Error", ex.getMessage(), data);

        return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResposta> handlerBadCredentialsException(Exception ex){

        String data = ConversorData.converterDateParaDataHora(new Date());

        ErrorResposta erro = new ErrorResposta(401, "Unauthorized", "Usuário ou senha inválidos", data);

        return new ResponseEntity<>(erro, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResposta> handlerAccessDeniedException(AccessDeniedException ex){

        String data = ConversorData.converterDateParaDataHora(new Date());

        ErrorResposta erro = new ErrorResposta(403, "Forbidden", ex.getMessage(), data);

        return new ResponseEntity<>(erro, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ResourceUnprocessableEntity.class)
    public ResponseEntity<ErrorResposta> handlerUnprocessableEntity(ResourceUnprocessableEntity ex){

        String data = ConversorData.converterDateParaDataHora(new Date());

        ErrorResposta erro = new ErrorResposta(422, "Unprocessable Content", ex.getMessage(), data);

        return new ResponseEntity<>(erro, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ResourceConflict.class)
    public ResponseEntity<ErrorResposta> handlerResourceConflict(ResourceConflict ex){

        String data = ConversorData.converterDateParaDataHora(new Date());

        ErrorResposta erro = new ErrorResposta(409, "Conflict", ex.getMessage(), data);

        return new ResponseEntity<>(erro, HttpStatus.CONFLICT);
    }

}
