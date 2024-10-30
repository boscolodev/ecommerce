package gbs.com.ecommerce.gateway;

import gbs.com.ecommerce.domain.model.Endereco;
import gbs.com.ecommerce.infrastructure.gateway.EnderecoGateway;
import gbs.com.ecommerce.infrastructure.persistence.EnderecoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnderecoGatewayTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @InjectMocks
    private EnderecoGateway enderecoGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findByCep_ReturnsEndereco_WhenCepExists() {
        String cep = "12345678";
        Endereco endereco = new Endereco();
        endereco.setCep(cep);
        when(enderecoRepository.findByCep(cep)).thenReturn(Optional.of(endereco));

        Optional<Endereco> result = enderecoGateway.findByCep(cep);

        assertTrue(result.isPresent());
        assertEquals(cep, result.get().getCep());
    }

    @Test
    void findByCep_ReturnsEmpty_WhenCepDoesNotExist() {
        String cep = "12345678";
        when(enderecoRepository.findByCep(cep)).thenReturn(Optional.empty());

        Optional<Endereco> result = enderecoGateway.findByCep(cep);

        assertFalse(result.isPresent());
    }

    @Test
    void save_PersistsEndereco() {
        Endereco endereco = new Endereco();
        when(enderecoRepository.save(endereco)).thenReturn(endereco);

        Endereco result = enderecoGateway.save(endereco);

        assertNotNull(result);
        verify(enderecoRepository, times(1)).save(endereco);
    }

    @Test
    void deleteById_RemovesEndereco() {
        String id = "1";

        enderecoGateway.deleteById(id);

        verify(enderecoRepository, times(1)).deleteById(id);
    }

    @Test
    void deleteByCep_RemovesEndereco() {
        String cep = "12345678";

        enderecoGateway.deleteByCep(cep);

        verify(enderecoRepository, times(1)).deleteByCep(cep);
    }
}