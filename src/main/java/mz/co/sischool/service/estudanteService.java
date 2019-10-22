package mz.co.sischool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mz.co.sischool.repository.estudanteRepository;
import mz.co.sischool.domain.Estudante;
import java.util.List;

@Service
public class estudanteService{
     @Autowired
    private estudanteRepository er;

    public void save(Estudante estudante){
        er.save(estudante);
    }

    public List<Estudante> Read(){
        return er.findAll();
    }

    public Estudante get(Long id){
        return er.findById(id).get();
    }

    public void delete(Long id){
        er.deleteById(id);
    }
}