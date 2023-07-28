package pdi.pdiapicadastro.domain.cliente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import pdi.pdiapicadastro.domain.endereco.DadosCadastroEndereco;

public record DadosCadastroCliente(
       @Id
        Long id,
        @NotBlank(message = "O preenchimento do campo nome é obrigatório!")
        String nome,
        @NotBlank(message = "O preenchimento do campo cpf é obrigatório!")
        String cpf,
        @Email
        @NotBlank(message = "O preenchimento do campo e-mail é obrigatório!")
        String email,
        String telefone,

        DadosCadastroEndereco endereco) {
}
