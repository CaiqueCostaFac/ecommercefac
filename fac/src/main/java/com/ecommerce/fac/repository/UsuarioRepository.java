package com.ecommerce.fac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.ecommerce.fac.model.Usuario;
 
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario  findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
}
