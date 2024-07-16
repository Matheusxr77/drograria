package br.org.drogaria.repository;

import br.org.drogaria.entity.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
    
}