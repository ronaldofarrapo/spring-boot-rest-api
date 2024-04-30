package med.voll.api.controller;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.usuario.DadosAutenticacao;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class UsuarioController {


    private final AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody DadosAutenticacao dadosAutenticacao){
        var token = new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(), dadosAutenticacao.senha());

        authenticationManager.authenticate(token);

        return ResponseEntity.ok().build();
    }

}
