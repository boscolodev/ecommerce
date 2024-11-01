package gbs.com.ecommerce.infrastructure.client;

import gbs.com.ecommerce.presentation.dto.EnderecoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    EnderecoResponseDTO getEnderecoByCep(@PathVariable("cep") String cep);
}
