package gbs.com.ecommerce.application.usecase;

import gbs.com.ecommerce.presentation.dto.EnderecoResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEnderecoUseCase {
    Page<EnderecoResponseDTO> findAllPaged(Pageable pageable);
    List<EnderecoResponseDTO> findAll();
    EnderecoResponseDTO findByCep(String id);
    EnderecoResponseDTO save(EnderecoResponseDTO endereco);
    EnderecoResponseDTO update(EnderecoResponseDTO endereco, String id);
    void deleteById(String id);
}
