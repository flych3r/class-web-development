package br.ufc.web._final.service;

import br.ufc.web._final.model.Cliente;
import br.ufc.web._final.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Cliente> listClientes() {
        return clienteRepository.findAll();
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente serchById(Long id) {
        return clienteRepository.getOne(id);
    }

}
