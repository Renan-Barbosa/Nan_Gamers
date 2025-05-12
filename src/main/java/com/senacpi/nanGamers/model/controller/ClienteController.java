
package com.senacpi.nanGamers.model.controller;

import com.senacpi.nanGamers.model.Cliente;
import com.senacpi.nanGamers.service.ClienteService;
import com.senacpi.nanGamers.service.VendasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cliente")

public class ClienteController {
     @Autowired
     private ClienteService clienteService;
   
    @Autowired
    private VendasServices vendasService;
    
 @GetMapping("/")
    public String inicio(){
      return "index"; 
    }

    
    @GetMapping("/cadastro")
    public String exibirFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes-cadastro";
    }
    
    @PostMapping("/gravar")
    public String processarFormularioCLiente(@ModelAttribute Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/cliente/listar";
    }
    
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "clientes-listagem";
    }
    
    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable int id, Model model) {
        model.addAttribute("cliente", clienteService.buscarPorId(id));
        return "clientes-cadastro";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        clienteService.excluir(id);
        return "redirect:/cliente/listar";
    }
    
    @GetMapping("/detalhes/{id}")
    public String exibirDetalhes(@PathVariable int id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id);
        
        model.addAttribute("cliente", cliente);
        model.addAttribute("vendass", vendasService.listarPorCliente(id));
        return "detalhes";
    }
}
