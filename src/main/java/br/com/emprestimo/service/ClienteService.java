package br.com.emprestimo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.emprestimo.model.ClienteModel;
import br.com.emprestimo.model.ResponseModel;
import br.com.emprestimo.repository.ClienteRepository;

@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	/**
	 * SALVAR UM NOVO
	 * @param cliente
	 * @return
	 */
	@RequestMapping(value="/cliente", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody ClienteModel cliente){
				
		
		try {
			
			this.clienteRepository.save(cliente);
			
			return new ResponseModel(1,"Registro salvo com sucesso!");
			
		}catch(Exception e) {
			
			return new ResponseModel(0,e.getMessage());			
		}
	}
	
	/**
	 * ATUALIZAR
	 * @param cliente
	 * @return
	 */
	@RequestMapping(value="/cliente", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody ClienteModel cliente){
		
		try {
			
			this.clienteRepository.save(cliente);		
			
			return new ResponseModel(1,"Registro atualizado com sucesso!");
		
		}catch(Exception e) {
			
			return new ResponseModel(0,e.getMessage());
		}
	}
	
	/**
	 * CONSULTAR
	 * @return
	 */
	@RequestMapping(value="/cliente", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<ClienteModel> consultar(){
		
		return (List<ClienteModel>) this.clienteRepository.findAll();
	}
	
	/**
	 * BUSCAR PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/cliente/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody
	ClienteModel buscar(@PathVariable("codigo") Integer codigo){
		
		return this.clienteRepository.findOne(codigo);
	}
	
	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/cliente/{codigo}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer codigo){
		
		ClienteModel clienteModel = clienteRepository.findOne(codigo);
		
		try {
			
			clienteRepository.delete(clienteModel);
			
			return new ResponseModel(1, "Registro excluido com sucesso!");
			
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
}
