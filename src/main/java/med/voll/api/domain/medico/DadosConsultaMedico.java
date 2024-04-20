package med.voll.api.domain.medico;

public record DadosConsultaMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosConsultaMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
