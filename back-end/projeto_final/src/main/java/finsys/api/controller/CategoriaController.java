package finsys.api.controller;

import finsys.api.domain.categoria.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCategoria dados, UriComponentsBuilder uriBuilder) {

        var categoria = new Categoria(dados);
        var uri = uriBuilder.path("/categoria/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCategoria(categoria));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCategoria>> listar(Pageable paginacao) {
        var page = repository.findByAtivoTrue(paginacao).map(DadosListagemCategoria::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCategoria dados) {
        var categoria = repository.getReferenceById(dados.id());
        categoria.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoCategoria(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        var categoria = repository.getReferenceById(id);
        categoria.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var categoria = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCategoria(categoria));
    }

}
