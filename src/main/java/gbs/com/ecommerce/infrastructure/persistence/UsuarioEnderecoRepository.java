package gbs.com.ecommerce.infrastructure.persistence;


import gbs.com.ecommerce.domain.model.UsuarioEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioEnderecoRepository extends JpaRepository<UsuarioEndereco, Long> {


    @Query(value = """
            SELECT id, usuario_id, endereco_id, numero, complemento
            FROM tb_usuario_endereco
            WHERE usuario_id = :usuarioId
            """, nativeQuery = true)
    List<UsuarioEndereco> findEnderecoByUsuario(@Param("usuarioId") String usuarioId);

}
