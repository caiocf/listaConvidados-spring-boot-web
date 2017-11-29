package br.com.caiocf.listvip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.caiocf.listvip.entidades.Convidado;
import br.com.caiocf.listvip.repository.ConvidadoRepository;
import br.com.caiocf.listvip.services.EmailService;

@Controller
public class ConvidadoController {

	static final Logger log = LoggerFactory.getLogger(ConvidadoController.class);
	
	@Autowired
	private ConvidadoRepository repositoryConvidado;
	
	@Autowired
	EmailService emailService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/listaconvidados")
	public String listaDeConvidados(Model model) {
		
		Iterable<Convidado> listaConvidados = repositoryConvidado.findAll();
		
		model.addAttribute("convidados", listaConvidados);
		return "listaconvidados";
	}
	
	@RequestMapping(value = "buscaconvidados", method = RequestMethod.POST)
	public String buscaDeConvidados(Model model, @RequestParam("nome")String nome) {
		
		Iterable<Convidado> listaConvidados = repositoryConvidado.findByNomeContainingAllIgnoreCase(nome);
		
		
		model.addAttribute("convidados", listaConvidados);
		return "listaconvidados";
	}
	
	@RequestMapping(value = "salvaConvidado", method = RequestMethod.POST)
	public String salvaConvidado(Model model, @RequestParam("nome")String nome, @RequestParam("email") String email, @RequestParam("telefone") String telefone) {
		
		Convidado convidadoNovo = new Convidado(nome, email, telefone);
		
		repositoryConvidado.save(convidadoNovo);
		
		emailService.enviar(nome, email);
		
		Iterable<Convidado> listaConvidados = repositoryConvidado.findAll();
		model.addAttribute("convidados", listaConvidados);
		
		return "listaconvidados";
	}
	
	@RequestMapping(value = "deletaConvidado", method = RequestMethod.POST)
	public String deletaDeConvidados(Model model, @RequestParam("id")Long id) {
		
		try {
		repositoryConvidado.delete(id);
		}catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			log.warn("Registro " + id + " nao existe no Sistema");
		}
		Iterable<Convidado> listaConvidados = repositoryConvidado.findAll();
		model.addAttribute("convidados", listaConvidados);
		
		return "listaconvidados";
	}
}
