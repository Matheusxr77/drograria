package br.org.drogaria.controller;

import br.org.drogaria.dto.RemedioDTO;
import br.org.drogaria.entity.Remedio;
import br.org.drogaria.service.RemedioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/remedios")
public class RemedioController {
    @Autowired
    private RemedioService remedioService;

    @GetMapping
    public List<RemedioDTO> listar() {
        return remedioService.listarRemedios();
    }

    @GetMapping("/buscar/{id}")
    public RemedioDTO buscarPorId(@PathVariable Long id) {
        return remedioService.buscarRemedioPorId(id);
    }

    @PostMapping("/criar")
    public RemedioDTO salvar(@RequestBody RemedioDTO remedio) {
        remedioService.criarRemedio(remedio);
        return remedio;
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Long id) {
        remedioService.deleteRemedio(id);
        return "Remedio deletado com sucesso!";
    }
}