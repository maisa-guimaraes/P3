package finsys.api.domain.categoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Table(name = "categoria")
@Entity(name = "Categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private boolean ativo;

    public Categoria(DadosCadastroCategoria dados) {
        this.nome = dados.nome();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoCategoria dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

    public Categoria(Categoria categoria) {
        this.id = categoria.getId();
    }

}
