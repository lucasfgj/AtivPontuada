package com.example.AtvPontSpringBoot.Service;

import com.example.AtvPontSpringBoot.Model.Funcionario;
import com.example.AtvPontSpringBoot.Repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    // Construtor da classe FuncionarioService.
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodos() {
        // Chama o método 'findAll' do FuncionarioRepository para buscar todos os registros de funcionários no banco de dados.
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(@Valid Funcionario funcionario){
        if(funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
            //Verifica se o email a ser cadastrado já existe no banco de dados.
            throw new RuntimeException("Email já cadastrado");
        }
        //A verificação a cima sendo falsa, salva as informações.
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(@Valid Funcionario funcionario){
        // Busca um funcionário existente no banco de dados com base no email fornecido.
        Funcionario funcAtualizar = funcionarioRepository.findByEmail(funcionario.getEmail())
                .orElseThrow(() -> new RuntimeException("Funcionario já cadastrado"));

        // Atualiza os dados do funcionário encontrado com os dados fornecidos no objeto 'funcionario'.
        funcAtualizar.setNome(funcionario.getNome());
        funcAtualizar.setEmail(funcionario.getEmail());
        funcAtualizar.setEndereco(funcionario.getEndereco());
        funcAtualizar.setSexo(funcionario.getSexo());
        funcAtualizar.setSalario(funcionario.getSalario());
        funcAtualizar.setCpf(funcionario.getCpf());
        funcAtualizar.setEstadoCivil(funcionario.getEstadoCivil());
        funcionario.setDataNascimento(funcionario.getDataNascimento());
        funcionario.setSetor(funcionario.getSetor());

        // Salva as alterações no banco de dados e retorna o objeto atualizado.
        return funcionarioRepository.save(funcAtualizar);
    }

    public void excluir(Long id){

        // Busca o funcionário no banco de dados pelo ID fornecido.
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario excluido"));

        // Exclui o funcionário do banco de dados com base no ID encontrado.
        funcionarioRepository.deleteById(funcionario.getId());
    }
}


