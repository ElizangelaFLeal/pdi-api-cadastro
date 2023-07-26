package pdi.pdiapicadastro.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdi.pdiapicadastro.domain.cliente.Cliente;
import pdi.pdiapicadastro.domain.cliente.ClienteRepository;
import pdi.pdiapicadastro.domain.cliente.DadosCadastroCliente;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;

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
}
