package gbs.com.ecommerce.application.usecase;

import gbs.com.ecommerce.presentation.dto.EnderecoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEnderecoUseCase {
    Page<EnderecoDTO> findAllPaged(Pageable pageable);
    List<EnderecoDTO> findAll();
    EnderecoDTO findByCep(String id);
    EnderecoDTO save(EnderecoDTO endereco);
    EnderecoDTO update(EnderecoDTO endereco, String id);
    void deleteById(String id);
}
