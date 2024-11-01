package gbs.com.ecommerce.presentation.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioEnderecoResponseDTO implements Serializable {

    @NotNull(message = "O campo id é obrigatório")
    private Long id;

    @NotEmpty(message = "O campo usuarioId é obrigatório")
    private String usuarioId;

    @NotEmpty(message = "O campo enderecoId é obrigatório")
    private String enderecoId;

    @NotEmpty(message = "O campo numero é obrigatório")
    private String numero;
    private String complemento;
}
