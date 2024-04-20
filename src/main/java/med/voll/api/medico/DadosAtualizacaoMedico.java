package med.voll.api.medico;

import jakarta.validation.constraints.NotBlank;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotBlank
        Long id,
        String nome,
        String telefone,
        DadosEndereco dadosEndereco) {
}
