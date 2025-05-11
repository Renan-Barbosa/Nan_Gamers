/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.senacpi.nanGamers.repository;

import com.senacpi.nanGamers.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nanba
 */
public interface ClienteRepository extends JpaRepository<Cliente, Integer>  {
    
}
