package pdi.pdiapicadastro.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import pdi.pdiapicadastro.domain.cliente.*;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCliente dadosCadastroCliente){
        clienteRepository.save(new Cliente(dadosCadastroCliente));
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarCliente dadosAtualizarCliente ){
        var dadosCliente = clienteRepository.getReferenceById(dadosAtualizarCliente.id());
        dadosCliente.atualizar(dadosAtualizarCliente);
    }
    @GetMapping
    public Page<DadosListagemCliente> listarClientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return clienteRepository.findAll(pageable).map(DadosListagemCliente::new);
    }
    @GetMapping("/{id}")
    public List<DadosListagemCliente> detalharCliente(@PathVariable Long id){
        return clienteRepository.findById(id).stream().map(DadosListagemCliente::new).toList();
    }
}
