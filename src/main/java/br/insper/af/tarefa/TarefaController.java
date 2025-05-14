package br.insper.af.tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarTarefaDTO criarTarefa(
            @AuthenticationPrincipal Jwt jwt,
            @RequestBody CadastrarTarefaDTO dto
    ) {
        String token = jwt.getTokenValue();
        List<String> roles = jwt.getClaimAsStringList("https://musica-insper.com/roles");
        return tarefaService.salvarTarefa(token, roles, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable String id
    ) {
        String token = jwt.getTokenValue();
        List<String> roles = jwt.getClaimAsStringList("https://musica-insper.com/roles");
        tarefaService.deletarTarefa(token, roles, id);
    }

    @GetMapping
    public List<Tarefa> listarTarefas(
            @AuthenticationPrincipal Jwt jwt
    ) {
        String email = jwt.getClaimAsString("https://musica-insper.com/email");
        List<String> roles = jwt.getClaimAsStringList("https://musica-insper.com/roles");
        return tarefaService.listarTarefas(email, roles);
    }
}
