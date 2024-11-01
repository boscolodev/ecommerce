package gbs.com.ecommerce.application.usecase;

import gbs.com.ecommerce.domain.exceptions.DatabaseException;
import gbs.com.ecommerce.domain.model.Endereco;
import gbs.com.ecommerce.domain.model.Usuario;
import gbs.com.ecommerce.domain.model.UsuarioEndereco;
import gbs.com.ecommerce.infrastructure.gateway.IEnderecoGateway;
import gbs.com.ecommerce.infrastructure.gateway.IUsuarioEnderecoGateway;
import gbs.com.ecommerce.infrastructure.gateway.IUsuarioGateway;
import gbs.com.ecommerce.infrastructure.mapper.Formatter;
import gbs.com.ecommerce.infrastructure.mapper.MapperUtil;
import gbs.com.ecommerce.presentation.dto.EnderecoResponseDTO;
import gbs.com.ecommerce.presentation.dto.UsuarioRequestDTO;
import gbs.com.ecommerce.presentation.dto.UsuarioResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioUseCase implements IUsuarioUseCase {
    private final IUsuarioEnderecoGateway usuarioEnderecoGateway;
    private final IUsuarioGateway usuarioGateway;
    private final IEnderecoGateway enderecoGateway;

    public Page<UsuarioResponseDTO> findAllPaged(Pageable pageable) {
        log.info("Buscando usuários paginados");
        return usuarioGateway.findAllPaged(pageable)
                .map(usuario -> MapperUtil.converte(usuario, UsuarioResponseDTO.class));
    }

    public List<UsuarioResponseDTO> findAll() {
        log.info("Buscando lista de endereços");
        return usuarioGateway.findAll().stream().map(usuario -> MapperUtil.converte(usuario, UsuarioResponseDTO.class)).toList();
    }

    @Transactional
    public UsuarioResponseDTO save(UsuarioRequestDTO usuarioRequestDTO) {

        log.info("Buscando endereço pelo CEP:", usuarioRequestDTO.getCep());
        Endereco endereco = enderecoGateway.findByCep(usuarioRequestDTO.getCep()).get();


        UsuarioEndereco usuarioEndereco = MapperUtil.converte(usuarioRequestDTO.getEnderecos(), UsuarioEndereco.class);
        usuarioEndereco.setEndereco(endereco);

        Usuario usuario = MapperUtil.converte(usuarioRequestDTO, Usuario.class);
        usuario.getUsuarioEnderecos().add(usuarioEndereco);

        return MapperUtil.converte(
                usuarioGateway.save(
                        MapperUtil.converte(usuarioRequestDTO, Usuario.class)),
                UsuarioResponseDTO.class);
    }

    public UsuarioResponseDTO update(UsuarioRequestDTO usuarioRequestDTO, String id) {
        Usuario usuario = usuarioGateway.findById(id).get();
        usuario.setId(id);
        MapperUtil.copyEntity(usuarioGateway, usuarioRequestDTO);
        return MapperUtil.converte(usuarioGateway.save(usuario), UsuarioResponseDTO.class);
    }

    public UsuarioResponseDTO findById(final String id) {
        return MapperUtil.converte(usuarioGateway.findById(id)
                .orElseThrow(() -> new DatabaseException(String.format("Usuário com ID: %S não encontrado", id))
                ), UsuarioResponseDTO.class);
    }

    public void deleteById(String id) {
        log.info("Deletando cep do ID:", id);
        usuarioGateway.deleteById(id);
    }
}

