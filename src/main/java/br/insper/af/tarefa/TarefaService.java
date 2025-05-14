package br.insper.af.tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public RetornarTarefaDTO salvarTarefa(String token, List<String> roles, CadastrarTarefaDTO dto) {
        if (!roles.contains("ADMIN")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apenas ADMIN pode criar tarefas.");
        }

        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setPrioridade(dto.prioridade());
        tarefa.setEmailCriador(dto.emailCriador());

        tarefa = tarefaRepository.save(tarefa);

        return new RetornarTarefaDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getPrioridade(),
                tarefa.getEmailCriador()
        );
    }

    public void deletarTarefa(String token, List<String> roles, String id) {
        if (!roles.contains("ADMIN")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apenas ADMIN pode deletar tarefas.");
        }

        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        tarefaRepository.delete(tarefa);
    }

    public List<Tarefa> listarTarefas(String email, List<String> roles) {
        return tarefaRepository.findAll(); // todos autenticados podem listar
    }
}
