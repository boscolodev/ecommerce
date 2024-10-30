package gbs.com.ecommerce.infrastructure.persistence;

import gbs.com.ecommerce.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {
    Optional<Endereco> findByCep(final String cep);
    void deleteByCep(final String cep);
}
