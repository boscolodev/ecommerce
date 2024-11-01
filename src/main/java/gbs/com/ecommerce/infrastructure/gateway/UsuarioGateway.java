package gbs.com.ecommerce.infrastructure.gateway;

import gbs.com.ecommerce.domain.exceptions.DatabaseException;
import gbs.com.ecommerce.domain.model.Usuario;
import gbs.com.ecommerce.infrastructure.persistence.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioGateway implements IUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    public Page<Usuario> findAllPaged(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(String id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(String id) {
        usuarioRepository.deleteById(id);
    }
}
