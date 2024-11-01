package gbs.com.ecommerce.application.usecase;

import gbs.com.ecommerce.presentation.dto.EnderecoResponseDTO;
import gbs.com.ecommerce.presentation.dto.UsuarioRequestDTO;
import gbs.com.ecommerce.presentation.dto.UsuarioResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUsuarioUseCase {
    Page<UsuarioResponseDTO> findAllPaged(Pageable pageable);
    List<UsuarioResponseDTO> findAll();
    UsuarioResponseDTO findById(String id);
    UsuarioResponseDTO save(UsuarioRequestDTO usuarioRequestDTO);
    UsuarioResponseDTO update(UsuarioRequestDTO usuarioRequestDTO, String id);
    void deleteById(String id);
}
