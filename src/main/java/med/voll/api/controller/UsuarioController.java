package med.voll.api.controller;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.usuario.DadosAutenticacao;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.infra.security.TokenFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class UsuarioController {


    private final AuthenticationManager authenticationManager;
    private final TokenFactory tokenFactory;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody DadosAutenticacao dadosAutenticacao){
        var token = new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(), dadosAutenticacao.senha());

        Authentication authenticate = authenticationManager.authenticate(token);

        return ResponseEntity.ok(tokenFactory.generate((Usuario) authenticate.getPrincipal()));
    }

}
