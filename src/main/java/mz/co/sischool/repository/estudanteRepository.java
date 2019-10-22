package mz.co.sischool.repository;

import mz.co.sischool.domain.Estudante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface estudanteRepository extends JpaRepository<Estudante, Long>{

}
