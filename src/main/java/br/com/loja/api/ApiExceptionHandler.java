package br.com.loja.api;
import br.com.loja.service.RegistroNaoEncontradoException;
import io.micrometer.observation.Observation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = "br.com.loja.controller.api")
public class ApiExceptionHandler {
	@ExceptionHandler(RegistroNaoEncontradoException.class)
	public ProblemDetail tratarNaoEncontrado(RegistroNaoEncontradoException exception) {
		ProblemDetail problema = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
		problema.setTitle("Registro nao encontrado");
		return problema;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail tratarValidacoes(MethodArgumentNotValidException exception){
		Map<String, String> erros = new LinkedHashMap<>();
		exception.getBindingResult().getFieldErrors().forEach(erro -> erros.put(erro.getField(), erro.getDefaultMessage()));
		ProblemDetail problema = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,"Existem Campos Invalidos");
		problema.setTitle("Erro de Validação");
		problema.setProperty("Erros",  erros);
		return problema;
	}

}
