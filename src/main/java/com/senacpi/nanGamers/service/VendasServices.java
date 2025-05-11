
package com.senacpi.nanGamers.service;

import com.senacpi.nanGamers.model.Vendas;
import com.senacpi.nanGamers.repository.VendasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendasServices {
    @Autowired
    private VendasRepository vendasRepository;
    
    public List<Vendas> listarPorCliente(int clienteId) {
        return vendasRepository.findByClienteId(clienteId);
    }
    
    public Vendas salvar(Vendas vendas) {  
        return vendasRepository.save(vendas);
    }
    
    public void excluir(int id) {
        vendasRepository.deleteById(id);
    }
    
    public Vendas buscarPorId(int id) {
        return vendasRepository.findById(id).orElse(null);
    }
    
}
