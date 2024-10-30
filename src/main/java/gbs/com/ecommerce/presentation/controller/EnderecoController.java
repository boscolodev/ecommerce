package gbs.com.ecommerce.presentation.controller;

import gbs.com.ecommerce.application.usecase.EnderecoUseCase;
import gbs.com.ecommerce.presentation.dto.EnderecoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoUseCase enderecoUseCase;

    @GetMapping("/cep/{cep}")
    public EnderecoDTO findCep(@PathVariable final String cep){
        return enderecoUseCase.findByCep(cep);
    }

    @GetMapping("/id/{id}")
    public EnderecoDTO findById(@PathVariable final String id){
        return enderecoUseCase.findById(id);
    }
}
