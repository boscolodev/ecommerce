package gbs.com.ecommerce.infrastructure.gateway;

import gbs.com.ecommerce.domain.model.Endereco;
import gbs.com.ecommerce.infrastructure.persistence.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnderecoGateway implements IEnderecoGateway{

    private final EnderecoRepository enderecoRepository;

    public Page<Endereco> findAllPaged(final Pageable pageable) {
        return enderecoRepository.findAll(pageable);
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> findById(final String id) {
        return enderecoRepository.findById(id);
    }
    public Optional<Endereco> findByCep(final String cep) {
        return enderecoRepository.findByCep(cep);
    }
    public Endereco save(final Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deleteById(final String id) {
        enderecoRepository.deleteById(id);
    }

    public void deleteByCep(final String cep){
        enderecoRepository.deleteByCep(cep);
    }
}
