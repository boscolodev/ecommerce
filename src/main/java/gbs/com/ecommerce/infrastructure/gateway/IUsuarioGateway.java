package gbs.com.ecommerce.infrastructure.gateway;

import gbs.com.ecommerce.domain.model.Endereco;
import gbs.com.ecommerce.domain.model.Usuario;
import gbs.com.ecommerce.infrastructure.persistence.EnderecoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUsuarioGateway {

    Page<Usuario> findAllPaged(Pageable pageable);
    List<Usuario> findAll();
    Optional<Usuario> findById(String id);
    Optional<Usuario> findByEmail(String email);
    Usuario save(Usuario usuario);
    void deleteById(String id);

}
