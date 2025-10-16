package com.trabalho.api_restful.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.api_restful.model.Tarefa;
import com.trabalho.api_restful.repository.TarefaRepository;

@RestController
@RequestMapping("/api-rest/tarefas")
public class TarefaController {
    private final TarefaRepository repository;

    public TarefaController(TarefaRepository tarefaRepository) {
        this.repository = tarefaRepository;
    }
    
    @GetMapping
    public List<?> findAll(){
    	return repository.findAll();
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return repository.findById(id)
            .map(task -> ResponseEntity.ok().body(task))
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/criar")
    public Tarefa create(@RequestBody Tarefa tarefa) {
    	return repository.save(tarefa);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Tarefa tarefa){
    	return repository.findById(id).map(edit -> {
    		edit.setNome(tarefa.getNome());
    		edit.setResponsavel(tarefa.getResponsavel());
    		edit.setData_entrega(tarefa.getData_entrega());
    		Tarefa updated = repository.save(edit);
    		return ResponseEntity.ok().body(updated);
    	}).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
    	return repository.findById(id).map(task -> {
    		repository.deleteById(id);
    		return ResponseEntity.ok().body("Tarefa com id: " + id + " deletada com sucesso");})
    		.orElse(ResponseEntity.notFound().build());
    	}
}
