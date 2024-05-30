package finsys.api.controller;

import finsys.api.domain.lancamento.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLancamento dados, UriComponentsBuilder uriBuilder) {
        var lancamento = new Lancamento(dados);
        repository.save(lancamento);

        var uri = uriBuilder.path("/lancamento/{id}").buildAndExpand(lancamento.getId()).toUri();

        System.out.println(dados);

        return ResponseEntity.created(uri).body(new DadosDetalhamentoLancamento(lancamento));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLancamento>> listar(@PageableDefault(size = 20, sort = {"dataPagamento"}) Pageable paginacao) {
        var page = repository.findAllByCorrenteTrue(paginacao).map(DadosListagemLancamento::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLancamento dados) {
        var lancamento = repository.getReferenceById(dados.id());
        lancamento.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var lancamento = repository.getReferenceById(id);
        lancamento.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalhar(@PathVariable Long id) {
        var lancamento = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }

}
