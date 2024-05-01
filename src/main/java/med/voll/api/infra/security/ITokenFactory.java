package med.voll.api.infra.security;

import med.voll.api.domain.usuario.Usuario;

public interface ITokenFactory {
    String generate(Usuario usuario);
}
