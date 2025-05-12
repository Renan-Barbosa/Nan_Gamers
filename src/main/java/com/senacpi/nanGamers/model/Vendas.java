
package com.senacpi.nanGamers.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Table(name="Vendas")
@Component
public class Vendas {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nome_cliente;
    private String produtos;
    private int preco;
    private int quantidade;
    private int valor_total;
    
    @ManyToOne
    @JoinColumn(name="cliente_id")
    @JsonBackReference
    private Cliente cliente;
}
