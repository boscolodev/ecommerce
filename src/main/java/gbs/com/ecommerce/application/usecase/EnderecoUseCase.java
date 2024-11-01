package gbs.com.ecommerce.application.usecase;

import gbs.com.ecommerce.domain.exceptions.DatabaseException;
import gbs.com.ecommerce.domain.model.Endereco;
import gbs.com.ecommerce.infrastructure.client.ViaCepClient;
import gbs.com.ecommerce.infrastructure.gateway.IEnderecoGateway;
import gbs.com.ecommerce.infrastructure.mapper.Formatter;
import gbs.com.ecommerce.infrastructure.mapper.MapperUtil;
import gbs.com.ecommerce.presentation.dto.EnderecoResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnderecoUseCase implements IEnderecoUseCase {
    private final IEnderecoGateway enderecoGateway;
    private final ViaCepClient viaCepClient;

    public Page<EnderecoResponseDTO> findAllPaged(Pageable pageable) {
        log.info("Buscando endereços paginados");
        return enderecoGateway.findAllPaged(pageable)
                .map(endereco -> MapperUtil.converte(endereco, EnderecoResponseDTO.class));
    }

    public List<EnderecoResponseDTO> findAll() {
        log.info("Buscando lista de endereços");
        return enderecoGateway.findAll().stream().map(endereco -> MapperUtil.converte(endereco, EnderecoResponseDTO.class)).toList();
    }

    public EnderecoResponseDTO findByCep(String cep) {
        log.info("Buscando cep {}", cep);
        return enderecoGateway.findByCep(Formatter.formatCepWithHyphen(cep))
                .map(endereco -> MapperUtil.converte(endereco, EnderecoResponseDTO.class))
                .orElseGet(() -> {
                    Endereco endereco = findCepAndSave(cep);
                    return MapperUtil.converte(endereco, EnderecoResponseDTO.class);
                });
    }

    public EnderecoResponseDTO save(EnderecoResponseDTO endereco) {
        return MapperUtil.converte(
                enderecoGateway.save(
                        MapperUtil.converte(endereco, Endereco.class)),
                EnderecoResponseDTO.class);
    }

    public EnderecoResponseDTO update(EnderecoResponseDTO enderecoResponseDTO, String id) {
        Endereco endereco = enderecoGateway.findById(id).get();
        endereco.setId(id);
        MapperUtil.copyEntity(enderecoResponseDTO, endereco);
        return MapperUtil.converte(enderecoGateway.save(endereco), EnderecoResponseDTO.class);
    }

    public EnderecoResponseDTO findById(final String id) {
        return MapperUtil.converte(enderecoGateway.findById(id)
                .orElseThrow(() -> new DatabaseException(String.format("Cep com ID: %S não encontrado", id))
                ), EnderecoResponseDTO.class);
    }

    public void deleteByCep(String cep) {
        log.info("Deletando cep", cep);
        enderecoGateway.deleteById(cep);
    }

    public void deleteById(String id) {
        log.info("Deletando cep do ID:", id);
        enderecoGateway.deleteById(id);
    }

    private Endereco findCepAndSave(final String cep) {
        log.info("Buscando {} no viaCep", cep);
        EnderecoResponseDTO enderecoByCep = viaCepClient.getEnderecoByCep(cep);
        log.info("Salvando {}", cep);
        return enderecoGateway.save(MapperUtil.converte(enderecoByCep, Endereco.class));
    }
}

