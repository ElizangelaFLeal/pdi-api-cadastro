package pdi.pdiapicadastro.domain.cliente;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pdi.pdiapicadastro.domain.endereco.DadosCadastroEndereco;
import pdi.pdiapicadastro.domain.endereco.Endereco;

import java.util.List;

@Table(name="clientes")
@Entity(name="Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    @Embedded
    private Endereco endereco;

    public Cliente(DadosCadastroCliente dadosCadastroCliente) {
        this.id = id;
        this.nome = dadosCadastroCliente.nome();
        this.cpf = dadosCadastroCliente.cpf();
        this.email = dadosCadastroCliente.email();
        this.telefone = dadosCadastroCliente.telefone();
        this.endereco = new Endereco(dadosCadastroCliente.endereco());
    }

    public void atualizar(DadosAtualizarCliente dadosAtualizarCliente) {
        if(dadosAtualizarCliente.telefone() != null){
            this.telefone = dadosAtualizarCliente.telefone();
        }
        if(dadosAtualizarCliente.endereco() != null){
            this.endereco.atualizarDadosEndereco(dadosAtualizarCliente.endereco());
        }
    }

    public void listar(DadosCadastroCliente dadosCadastroCliente) {
        getId();
    }
}
