package model.exception;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private Map<String, String> errors = new HashMap<>();  
	
	public ValidationException(String msg) {
		super(msg);
	}
	
	public Map<String, String> getErrors(){
		return errors;
	}
	
	//Método para adicionar mensagem de erro.
	
	public void addError(String fieldName, String erroMensage) {
		errors.put(fieldName, erroMensage);
	}
}
