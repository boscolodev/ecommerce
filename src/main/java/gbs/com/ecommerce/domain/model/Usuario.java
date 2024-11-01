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
@Table(name = "tb_usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario implements Serializable {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(unique = true)
    private String nome;
    @Column(unique = true)
    private String sobrenome;

    @Column(unique = true)
    private String email;
    private String senha;

    @Column(unique = true)
    private String documento;
    @Column(unique = true)
    private String rg;
    private String telefone;
    private String celular;
    private String sexo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioEndereco> usuarioEnderecos = new ArrayList<>();

}