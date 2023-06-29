package dev.lucasmachado.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.lucasmachado.enterprise.entities.AbstractEntity;
import dev.lucasmachado.model.Cliente;
import dev.lucasmachado.model.ItemPedido;
import dev.lucasmachado.model.Pagamento;
import dev.lucasmachado.model.localidades.Endereco;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedidos")
public class Pedido extends AbstractEntity {

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "i_clientes")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "i_enderecos_entregas")
    private Endereco enderecoEntrega;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Long id, Date instante, Cliente cliente, Endereco enderecoEntrega) {
        super(id);
        this.instante = instante;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }
}