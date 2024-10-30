package gbs.com.ecommerce.infrastructure.gateway;

import gbs.com.ecommerce.domain.model.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEnderecoGateway {
    Page<Endereco> findAllPaged(Pageable pageable);
    List<Endereco> findAll();
    Optional<Endereco> findById(String id);
    Optional<Endereco> findByCep(String cep);
    Endereco save(Endereco endereco);
    void deleteById(String id);
    void deleteByCep(String cep);

}
