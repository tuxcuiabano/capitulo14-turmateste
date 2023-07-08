package br.edu.ficdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ficdev.model.Turma;


public interface TurmaRepository extends JpaRepository<Turma, Long> {
    // Aqui você pode definir consultas personalizadas, se necessário
}