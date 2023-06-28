package dev.lucasmachado.repositories;

import dev.lucasmachado.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pagamento, Long> {
}
