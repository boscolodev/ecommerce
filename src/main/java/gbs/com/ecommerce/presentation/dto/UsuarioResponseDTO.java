package gbs.com.ecommerce.presentation.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioResponseDTO implements Serializable {
    @NotEmpty(message = "O campo id é obrigatório")
    private String id;
    @NotEmpty(message = "O campo nome é obrigatório")
    private String nome;
    private String sobrenome;
    @NotEmpty(message = "O campo email é obrigatório")
    private String email;
    @NotEmpty(message = "O campo senha é obrigatório") @Size(min = 6, message = "A senha deve conter no mínimo 6 caracteres")
    private String senha;
    @NotEmpty(message = "O campo CPF/CNPJ de documento é obrigatório")
    private String documento;
    private String rg;
    private String telefone;
    private String celular;
    @NotEmpty(message = "O campo sexo é obrigatório")
    private String sexo;
    private List<UsuarioEnderecoRequestDTO> enderecos = new ArrayList<>();
}
