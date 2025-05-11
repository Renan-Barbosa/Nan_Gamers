/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.senacpi.nanGamers.repository;

import com.senacpi.nanGamers.model.Vendas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nanba
 */
public interface VendasRepository  extends JpaRepository<Vendas, Integer> {
    List<Vendas> findByClienteId(int clienteId);
    
}
