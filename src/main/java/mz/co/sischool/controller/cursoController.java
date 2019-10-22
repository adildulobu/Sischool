package mz.co.sischool.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import mz.co.sischool.service.cursoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import mz.co.sischool.domain.Curso;

@Controller
public class cursoController{
    @Autowired
    private cursoService serv;

    @RequestMapping("/curso")
	public String viewCursoPage(Model model) {
	    List<Curso> listcurso = serv.Read();
	    model.addAttribute("listcurso", listcurso);
	    return "curso/curso";
    }
    
    @RequestMapping("curso/novo-curso")
	public String showNewCursoPage(Model model) {
	    Curso curso = new Curso();
	    model.addAttribute("curso", curso); 
	    return "curso/criar-curso";
	}
	
	@RequestMapping(value = "/salvar-curso", method = RequestMethod.POST)
	public String saveCurso(@ModelAttribute("curso") Curso curso) {
	    serv.save(curso);
	    return "redirect:/curso";
    }
    
    @RequestMapping("curso/editar-curso/{id}")
	public ModelAndView showEditCursoPage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("curso/edit-curso");
	    Curso curso = serv.get(id);
	    mav.addObject("curso", curso);
	    return mav;
	}
	
	@RequestMapping("curso/apagar-curso/{id}")
	public String deleteCurso(@PathVariable(name = "id") Long id) {
	    serv.delete(id);
	    return "redirect:/curso";       
	}


}