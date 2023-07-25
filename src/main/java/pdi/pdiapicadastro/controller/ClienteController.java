package pdi.pdiapicadastro.controller;

import pdi.pdiapicadastro.domain.cliente.DadosCadastroCliente;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroCliente dadosCadastroCliente){
        System.out.println(dadosCadastroCliente);
    }
}
