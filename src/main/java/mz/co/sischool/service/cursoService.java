package mz.co.sischool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mz.co.sischool.repository.cursoRepository;
import mz.co.sischool.domain.Curso;
import java.util.List;

@Service
public class cursoService{
     @Autowired
    private cursoRepository cr;

    public void save(Curso curso){
        cr.save(curso);
    }

    public List<Curso> Read(){
        return cr.findAll();
    }

    public Curso get(long id) {
        return cr.findById(id).get();
    }

    public void delete(Long id){
        cr.deleteById(id);
    }
}