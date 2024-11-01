package gbs.com.ecommerce.infrastructure.gateway;

import gbs.com.ecommerce.domain.model.UsuarioEndereco;
import gbs.com.ecommerce.infrastructure.persistence.UsuarioEnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioEnderecoGateway implements IUsuarioEnderecoGateway {

    private final UsuarioEnderecoRepository usuarioEnderecoRepository;

    public UsuarioEndereco save(UsuarioEndereco usuarioEndereco) {
        return usuarioEnderecoRepository.save(usuarioEndereco);
    }

    public void delete(Long id) {
        usuarioEnderecoRepository.deleteById(id);
    }

    public Optional<UsuarioEndereco> findById(Long id) {
        return usuarioEnderecoRepository.findById(id);
    }

    public List<UsuarioEndereco> findEnderecoByUsuario(String idUsuario) {
        return usuarioEnderecoRepository.findEnderecoByUsuario(idUsuario);
    }
}
