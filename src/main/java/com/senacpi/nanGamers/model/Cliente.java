
package com.senacpi.nanGamers.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Table(name="Cliente")
@Component

public class Cliente {
     @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  
    private String nome_cliente;
    private String email;
    private String senha;
    private int cpf;  
    private int  rg;
    
    @OneToMany(mappedBy="cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vendas> vendas = new ArrayList<>();
    
    public void adicionarVenda(Vendas venda) {
        venda.setCliente(this);
        this.vendas.add(venda);
    }
    
}
