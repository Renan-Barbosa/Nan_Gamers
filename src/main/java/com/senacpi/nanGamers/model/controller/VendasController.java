
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

@Controller

public class VendasController {
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private VendasServices vendasService;
    
    
    @PostMapping("/gravar/{clienteId}")
    public String adicionarVenda(@PathVariable int ClienteId, @ModelAttribute Vendas novaVenda) {
        Cliente cliente = clienteService.buscarPorId(ClienteId);
        if (cliente != null) {
            cliente.adicionarVenda(novaVenda);
            clienteService.salvar(cliente);
        }
        return "redirect:/detalhes/" + ClienteId;
    }
    
   /* @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        vendasService.excluir(id);
        return "redirect:/listar";
    }*/
}
