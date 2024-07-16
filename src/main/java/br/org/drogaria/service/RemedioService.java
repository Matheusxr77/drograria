package br.org.drogaria.service;

import br.org.drogaria.dto.RemedioDTO;
import br.org.drogaria.entity.Remedio;
import br.org.drogaria.repository.RemedioRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RemedioService {
    @Autowired
    private RemedioRepository remedioRepository;

    public List<RemedioDTO> listarRemedios() {
        List<Remedio> remedios = remedioRepository.findAll();
        return remedios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public RemedioDTO buscarRemedioPorId(Long id) {
        Remedio remedio = remedioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remédio não encontrado"));
        return convertToDTO(remedio);
    }

    public RemedioDTO criarRemedio(RemedioDTO remedioDTO) {
        Remedio remedio = convertToEntity(remedioDTO);
        remedio = remedioRepository.save(remedio);
        return convertToDTO(remedio);
    }

    public void deleteRemedio(Long id) {
        Remedio remedio = remedioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remédio não encontrado"));
        remedioRepository.delete(remedio);
    }

    private RemedioDTO convertToDTO(Remedio remedio) {
        RemedioDTO remedioDTO = new RemedioDTO();
        BeanUtils.copyProperties(remedio, remedioDTO);
        return remedioDTO;
    }

    private Remedio convertToEntity(RemedioDTO remedioDTO) {
        Remedio remedio = new Remedio();
        BeanUtils.copyProperties(remedioDTO, remedio);
        return remedio;
    }
}