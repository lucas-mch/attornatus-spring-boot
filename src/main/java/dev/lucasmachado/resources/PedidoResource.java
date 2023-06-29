package dev.lucasmachado.resources;

import dev.lucasmachado.model.Cliente;
import dev.lucasmachado.model.Pedido;
import dev.lucasmachado.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        Pedido toFind = pedidoService.findById(id);
        return ResponseEntity.ok().body(toFind);
    }



}