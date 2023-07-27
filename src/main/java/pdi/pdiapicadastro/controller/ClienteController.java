package pdi.pdiapicadastro.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdi.pdiapicadastro.domain.cliente.Cliente;
import pdi.pdiapicadastro.domain.cliente.ClienteRepository;
import pdi.pdiapicadastro.domain.cliente.DadosAtualizarCliente;
import pdi.pdiapicadastro.domain.cliente.DadosCadastroCliente;
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
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }
}
