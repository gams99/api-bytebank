package com.gams.apibytebank.controller;

import com.gams.apibytebank.controller.dto.AccountDto;
import com.gams.apibytebank.controller.dto.ClientDto;
import com.gams.apibytebank.model.Account;
import com.gams.apibytebank.model.Client;
import com.gams.apibytebank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    public List<ClientDto> toList(){
        List<Client> clients = clientRepository.findAll();
        return ClientDto.convert(clients);
    }

    @GetMapping(value = "/{id}") //return dto
    public ResponseEntity<ClientDto> find(@PathVariable Integer id) { //@Path is to 'linkar' the id above
        Optional<Client> client = clientRepository.findById(id); //connected with @AutowiredClient service above
        if (client.isPresent()) {
            return ResponseEntity.ok(new ClientDto(client.get())); //return the response and found obj
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}