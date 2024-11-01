package gbs.com.ecommerce.application.usecase;

import gbs.com.ecommerce.presentation.dto.EnderecoResponseDTO;
import gbs.com.ecommerce.presentation.dto.UsuarioEnderecoRequestDTO;
import gbs.com.ecommerce.presentation.dto.UsuarioEnderecoResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUsuarioEnderecoUseCase {
    List<UsuarioEnderecoResponseDTO> findEnderecosByUsuario(final String usuarioId);
    UsuarioEnderecoResponseDTO findByEnderecoId(final Long id);
    UsuarioEnderecoResponseDTO save(final UsuarioEnderecoRequestDTO usuarioEnderecoRequestDTO);
    UsuarioEnderecoResponseDTO update(final UsuarioEnderecoRequestDTO usuarioEnderecoRequestDTO,final Long id);
    void deleteById(final Long id);
}
