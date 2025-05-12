
package com.senacpi.nanGamers.model.controller;

import com.senacpi.nanGamers.model.Cliente;
import com.senacpi.nanGamers.model.Vendas;
import com.senacpi.nanGamers.service.ClienteService;
import com.senacpi.nanGamers.service.VendasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendas")
public class VendasController {
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private VendasServices vendasService;
    
    
    @PostMapping("/gravar/{clienteId}")
    public String adicionarVenda(@PathVariable int clienteId, @ModelAttribute Vendas novaVendas) {
        Cliente cliente = clienteService.buscarPorId(clienteId);
        if (cliente != null) {
            cliente.adicionarVenda(novaVendas);
            clienteService.salvar(cliente);
        }
        return "redirect:/cliente/detalhes/" + clienteId;
    }
    
   @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        vendasService.excluir(id);
        return "redirect:/cliente/listar";
    }
}
