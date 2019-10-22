package mz.co.sischool.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mz.co.sischool.domain.Curso;
import mz.co.sischool.domain.Estudante;
import mz.co.sischool.service.cursoService;
import mz.co.sischool.service.estudanteService;

@Controller
public class estudanteController {
	
	@Autowired
	private estudanteService serv;
	
	@Autowired
	private cursoService serv1;
	
	
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	@RequestMapping("/estudante")
	public String viewEstudantePage(Model model) {
	    List<Estudante> listestudante = serv.Read();
	    model.addAttribute("listestudante", listestudante);
	    List<Curso> listcurso = serv1.Read();
	    model.addAttribute("listcurso", listcurso);
	    return "estudante/estudante";
	}
	@RequestMapping("estudante/novo-estudante")
	public String showNewEstudantePage(Model model) {
	    Estudante estudante = new Estudante();
	    model.addAttribute("estudante", estudante); 
	    List<Curso> listcurso = serv1.Read();
	    model.addAttribute("listcurso", listcurso);
	    return "estudante/criar-estudante";
	}
	
	@RequestMapping(value = "/salvar-estudante", method = RequestMethod.POST)
	public String saveEstudante(@ModelAttribute("estudante") Estudante estudante) {
	    serv.save(estudante);
	    return "redirect:/estudante";
	}
	
	@RequestMapping("estudante/editar-estudante/{id}")
	public ModelAndView showEditEstudantePage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("estudante/edit-estudante");
	    Estudante estudante = serv.get(id);
	    mav.addObject("estudante", estudante);
	    return mav;
	}
	
	
	
	@RequestMapping("estudante/apagar-estudante/{id}")
	public String deleteEstudante(@PathVariable(name = "id") Long id) {
	    serv.delete(id);
	    return "redirect:/estudante";       
	}
}
