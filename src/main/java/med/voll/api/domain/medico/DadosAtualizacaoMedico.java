package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotBlank;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotBlank
        Long id,
        String nome,
        String telefone,
        DadosEndereco dadosEndereco) {
}
