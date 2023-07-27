package pdi.pdiapicadastro.domain.cliente;

import pdi.pdiapicadastro.domain.endereco.DadosCadastroEndereco;

public record DadosAtualizarCliente(Long id, String telefone, DadosCadastroEndereco endereco) {
}
