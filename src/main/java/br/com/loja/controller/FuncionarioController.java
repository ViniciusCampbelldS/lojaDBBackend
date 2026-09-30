package br.com.loja.controller;
import br.com.loja.model.Funcionario;
// import das Anotações
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// outros imports
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {
	
	@GetMapping("/funcionarios")
	public String listar(Model model){
		Funcionario funcionario0 = new Funcionario(0101,"Pedro","Caixa","55566677788",3000.00);
		Funcionario funcionario1 = new Funcionario(1001,"Algusto","Gerente","11122233344",4000.00);
		Funcionario funcionario2 = new Funcionario(1010,"Alfredo","Fiscal","99910111112",3500.00);
		List<Funcionario> funcionarios = List.of(funcionario0, funcionario1, funcionario2);
		model.addAttribute("funcionarios", funcionarios);
		return "funcionarios";
	}
}