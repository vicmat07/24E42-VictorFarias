package br.edu.infnet.victor.farias;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.infnet.victor.farias.exceptions.ApplicationBaseException;
import br.edu.infnet.victor.farias.exceptions.ConsultaNaoEncontradaException;
import br.edu.infnet.victor.farias.exceptions.DataConsultaInvalidaException;
import br.edu.infnet.victor.farias.exceptions.FisioterapeutaNaoEncontradoException;
import br.edu.infnet.victor.farias.exceptions.GuiaExpiradaException;
import br.edu.infnet.victor.farias.exceptions.GuiaNaoEncontradaException;
import br.edu.infnet.victor.farias.exceptions.PacienteNaoEncontradoException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {

        Map<String, String> errors = new HashMap<>();
        Set<javax.validation.ConstraintViolation<?>> violations = ex.getConstraintViolations();
        
        for (javax.validation.ConstraintViolation<?> violation : violations) {
            String fieldName = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(fieldName, message);
        }
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
	
	@ExceptionHandler(ApplicationBaseException.class)
	public ResponseEntity<Object> handleValidationExceptions(ApplicationBaseException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
