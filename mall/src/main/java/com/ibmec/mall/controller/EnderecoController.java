package com.ibmec.mall.controller;

import com.ibmec.mall.model.Usuario;
import com.ibmec.mall.model.Endereco;
import com.ibmec.mall.repository.UsuarioRepository;
import com.ibmec.mall.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address/{id_user}")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Endereco> create(@PathVariable("id_user") int id_user, @RequestBody Endereco endereco) {
        //Verificando se o usuario existe na base
        Optional<Usuario> optionalUsuario = this.usuarioRepository.findById(id_user);

        if (optionalUsuario.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        //Cria o endereco  na base
        enderecoRepository.save(endereco);

        //Associa o endereco ao usuario
        Usuario usuario = optionalUsuario.get();

        usuario.getEnderecos().add(endereco);
        usuarioRepository.save(usuario);

        return new ResponseEntity<>(endereco, HttpStatus.CREATED);

    }

}