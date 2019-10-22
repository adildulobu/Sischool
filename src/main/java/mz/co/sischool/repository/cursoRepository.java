package mz.co.sischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mz.co.sischool.domain.Curso;

public interface cursoRepository extends JpaRepository<Curso, Long> {

}
