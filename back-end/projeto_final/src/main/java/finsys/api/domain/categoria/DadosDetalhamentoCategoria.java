package finsys.api.domain.categoria;

public record DadosDetalhamentoCategoria(
        Long id,
        String nome,
        boolean ativo
) {

    public DadosDetalhamentoCategoria(Categoria categoria) {
        this(categoria.getId(),
                categoria.getNome(),
                categoria.isAtivo());
    }

}
