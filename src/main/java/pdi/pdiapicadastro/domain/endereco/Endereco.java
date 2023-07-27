package pdi.pdiapicadastro.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    private String logradouro;

    private String bairro;

    private String cep;

    private String numero;

    private String complemento;

    private String cidade;

    private String uf;

    public Endereco(DadosCadastroEndereco dadosCadastroEndereco) {
        this.logradouro = dadosCadastroEndereco.logradouro();
        this.bairro = dadosCadastroEndereco.bairro();
        this.cep = dadosCadastroEndereco.cep();
        this.numero = dadosCadastroEndereco.numero();
        this.complemento = dadosCadastroEndereco.complemento();
        this.cidade = dadosCadastroEndereco.cidade();
        this.uf = dadosCadastroEndereco.uf();
    }
    public void atualizarDadosEndereco(DadosCadastroEndereco dadosAtualizaEndereco) {
        if(dadosAtualizaEndereco.logradouro() != getLogradouro()){
            this.logradouro = dadosAtualizaEndereco.logradouro();
        }
        if(dadosAtualizaEndereco.bairro() != getBairro()){
            this.bairro = dadosAtualizaEndereco.bairro();
        }
        if(dadosAtualizaEndereco.cep() != getCep()){
            this.cep = dadosAtualizaEndereco.cep();
        }
        if(dadosAtualizaEndereco.numero() != getNumero()){
            this.numero = dadosAtualizaEndereco.numero();
        }
        if(dadosAtualizaEndereco.complemento() != getComplemento()){
            this.complemento = dadosAtualizaEndereco.complemento();
        }
        if(dadosAtualizaEndereco.cidade() != getCidade()){
            this.cidade = dadosAtualizaEndereco.cidade();
        }
        if(dadosAtualizaEndereco.uf() != getUf()){
            this.uf = dadosAtualizaEndereco.uf();
        }
    }

}
