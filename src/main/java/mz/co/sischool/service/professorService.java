package mz.co.sischool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mz.co.sischool.repository.professorRepository;
import mz.co.sischool.domain.Professor;
import java.util.List;

@Service
public class professorService{
     @Autowired
    private professorRepository pr;

    public void save(Professor professor){
        pr.save(professor);
    }

    public List<Professor> Read(){
        return pr.findAll();
    }

    public Professor get(long id) {
        return pr.findById(id).get();
    }

    public void delete(Long id){
        pr.deleteById(id);
    }
}