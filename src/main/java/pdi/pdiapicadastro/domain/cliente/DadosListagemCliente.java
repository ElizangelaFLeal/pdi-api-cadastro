package pdi.pdiapicadastro.domain.cliente;

import pdi.pdiapicadastro.domain.endereco.DadosCadastroEndereco;
import pdi.pdiapicadastro.domain.endereco.Endereco;

public record DadosListagemCliente(Long id, String nome, String cpf, String email, String telefone, Endereco endereco) {

    public DadosListagemCliente (Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone(),cliente.getEndereco());
    }
}
