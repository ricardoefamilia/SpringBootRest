package br.com.springboot.curso_jdev_treinamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.curso_jdev_treinamento.model.Usuario;
import br.com.springboot.curso_jdev_treinamento.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController /* mapeia todas as requisições */
public class GreetingsController {
	
	@Autowired /* IC/CD ou CDI injeção de dependência  */
	private UsuarioRepository usuarioRepository;
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Curso Spring Boot API: " + name + "!";
    }
    
    @RequestMapping(value = "/mensagem/{msg}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String retornaMsg(@PathVariable String msg) {
    	
    	Usuario usuario = new Usuario();
    	usuario.setNome(msg);
    	usuarioRepository.save(usuario);
    	return "Mensagem: " + msg;
    }
    
}
