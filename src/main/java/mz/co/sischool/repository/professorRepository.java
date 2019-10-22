package mz.co.sischool.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import mz.co.sischool.domain.Professor;

public interface professorRepository extends JpaRepository<Professor,Long>{

}