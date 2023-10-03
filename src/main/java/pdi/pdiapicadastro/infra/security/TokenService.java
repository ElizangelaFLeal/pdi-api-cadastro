package pdi.pdiapicadastro.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pdi.pdiapicadastro.domain.cliente.Cliente;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${pdi.api.token.security}")
    private String segredo;

    public String gerarToken(Cliente cliente){
        System.out.println(segredo);
        try {
            var algoritmo = Algorithm.HMAC256("123456");
            return JWT.create()
                    .withIssuer("API Voll.med")
                    .withSubject(cliente.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token jwt", exception);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
