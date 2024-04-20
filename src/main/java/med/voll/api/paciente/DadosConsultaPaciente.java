package med.voll.api.paciente;

public record DadosConsultaPaciente(Long id, String nome, String email, String cpf) {

    public DadosConsultaPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}
