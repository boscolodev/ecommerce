package gbs.com.ecommerce.infrastructure.gateway;

import gbs.com.ecommerce.domain.model.UsuarioEndereco;

import java.util.List;
import java.util.Optional;

public interface IUsuarioEnderecoGateway {
    Optional<UsuarioEndereco> findById(Long id);
    List<UsuarioEndereco> findEnderecoByUsuario(String idUsuario);
    UsuarioEndereco save(UsuarioEndereco usuarioEndereco);
    void delete(Long id);
}
