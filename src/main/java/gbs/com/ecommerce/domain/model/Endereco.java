package gbs.com.ecommerce.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_endereco")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Endereco implements Serializable {

    @Id
    private String id = UUID.randomUUID().toString();
    @Column(unique = true)
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    @OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioEndereco> usuarioEnderecos = new ArrayList<>();
}
