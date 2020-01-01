package br.com.alura.microservices.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservices.loja.entity.CompraEntity;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity, Long> {

}
