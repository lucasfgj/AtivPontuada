package com.example.AtvPontSpringBoot.Repository;

import com.example.AtvPontSpringBoot.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    // Este método define uma consulta customizada para encontrar um funcionário pelo seu email.
    Optional<Funcionario> findByEmail(String email);
}
