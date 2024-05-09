package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendaDeConsultasService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados){
        Optional<Medico> medico = medicoRepository.findById(dados.idMedico());
        Optional<Paciente> paciente = pacienteRepository.findById(dados.idPaciente());

        var consulta = new Consulta(null, medico.get(), paciente.get(), dados.data());
        consultaRepository.save(consulta);
    }

}
