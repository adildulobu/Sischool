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


import mz.co.sischool.domain.Professor;
import mz.co.sischool.service.professorService;;

@Controller
public class professorController {

	@Autowired
	private professorService serv;
	
	@RequestMapping("/professor")
	public String viewProfessorPage(Model model) {
	    List<Professor> listprof = serv.Read();
	    model.addAttribute("listprof", listprof);
	    return "professor/professor";
	}
	@RequestMapping("professor/novo-professor")
	public String showNewProfessorPage(Model model) {
	    Professor professor = new Professor();
	    model.addAttribute("professor", professor); 
	    return "professor/criar-professor";
	}
	
	@RequestMapping(value = "/salvar-professor", method = RequestMethod.POST)
	public String saveProfessor(@ModelAttribute("professor") Professor professor) {
	    serv.save(professor);
	    return "redirect:/professor";
	}
	@RequestMapping("professor/editar-professor/{id}")
	public ModelAndView showEditProfessorPage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("professor/edit-professor");
	    Professor professor = serv.get(id);
	    mav.addObject("professor", professor);
	    return mav;
	}
	
	@RequestMapping("professor/apagar-professor/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
	    serv.delete(id);
	    return "redirect:/professor";       
	}
}
