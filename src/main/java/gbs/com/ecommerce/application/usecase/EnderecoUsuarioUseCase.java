package gbs.com.ecommerce.application.usecase;

import gbs.com.ecommerce.domain.exceptions.DatabaseException;
import gbs.com.ecommerce.domain.model.UsuarioEndereco;
import gbs.com.ecommerce.infrastructure.gateway.IUsuarioEnderecoGateway;
import gbs.com.ecommerce.infrastructure.mapper.MapperUtil;
import gbs.com.ecommerce.presentation.dto.UsuarioEnderecoRequestDTO;
import gbs.com.ecommerce.presentation.dto.UsuarioEnderecoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoUsuarioUseCase implements IUsuarioEnderecoUseCase{

    private final IUsuarioEnderecoGateway usuarioEnderecoGateway;
    public List<UsuarioEnderecoResponseDTO> findEnderecosByUsuario(final String usuarioId) {
        return usuarioEnderecoGateway.findEnderecoByUsuario(usuarioId)
                .stream()
                .map(usuarioEndereco -> MapperUtil.converte(usuarioEndereco, UsuarioEnderecoResponseDTO.class))
                .toList();

    }

    public UsuarioEnderecoResponseDTO findByEnderecoId(final Long id) {
        return MapperUtil.converte(this.findById(id), UsuarioEnderecoResponseDTO.class);
    }

    private UsuarioEndereco findById(final Long id){
        return usuarioEnderecoGateway.findById(id)
                .orElseThrow( () -> new DatabaseException("Endereço não encontrado"));
    }

    public UsuarioEnderecoResponseDTO save(final UsuarioEnderecoRequestDTO usuarioEnderecoRequestDTO) {
        return MapperUtil.converte(usuarioEnderecoGateway.save(MapperUtil.converte(usuarioEnderecoRequestDTO, UsuarioEndereco.class)), UsuarioEnderecoResponseDTO.class);
    }

    public UsuarioEnderecoResponseDTO update(final UsuarioEnderecoRequestDTO usuarioEnderecoRequestDTO, Long id) {
        UsuarioEndereco usuarioEndereco = this.findById(id);
        usuarioEndereco.setId(id);
        MapperUtil.copyEntity(usuarioEndereco, usuarioEnderecoRequestDTO);
        return MapperUtil.converte(usuarioEnderecoGateway.save(usuarioEndereco), UsuarioEnderecoResponseDTO.class);
    }

    public void deleteById(final Long id) {
        usuarioEnderecoGateway.delete(id);
    }
}
