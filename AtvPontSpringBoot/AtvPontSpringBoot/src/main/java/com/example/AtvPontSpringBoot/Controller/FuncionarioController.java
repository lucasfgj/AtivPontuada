package com.example.AtvPontSpringBoot.Controller;

import com.example.AtvPontSpringBoot.Model.Funcionario;
import com.example.AtvPontSpringBoot.Service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private FuncionarioService funcionarioService;
    public FuncionarioController (FuncionarioService funcionarioService){
        // Isso permite que os métodos da classe FuncionarioController utilizem os serviços fornecidos por FuncionarioService.
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> listarTodos(){
        // Chama o método 'listarTodos' da classe FuncionarioService para obter a lista de todos os funcionários.
        return funcionarioService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody Funcionario funcionario){
        // Chama o método 'salvar' do serviço 'funcionarioService' para salvar o funcionário no banco de dados.
        funcionarioService.salvar(funcionario);
        // Retorna uma resposta HTTP com o status 201 (Created) e uma mensagem indicando que o funcionário foi cadastrado.
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario " + funcionario.getNome() + " Cadastrado ");
    }

    @PutMapping
    public ResponseEntity<String> atualizar(@Valid @RequestBody Funcionario funcionario){
        // Chama o método 'atualizar' do serviço 'funcionarioService' para atualizar o funcionário no banco de dados.
        funcionarioService.atualizar(funcionario);
        // Retorna uma resposta HTTP com o status 201 (Created) e uma mensagem indicando que o funcionário foi atualizado.
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario " + funcionario.getNome() + " Atualizado ");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@Valid @RequestBody Long id){
        // Chama o método 'excluir' do serviço 'funcionarioService' para excluir o funcionário no banco de dados.
        funcionarioService.excluir(id);
        // Retorna uma resposta HTTP com o status 201 (Created) e uma mensagem indicando que o funcionário foi deletado.
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario deletado");
    }
}
