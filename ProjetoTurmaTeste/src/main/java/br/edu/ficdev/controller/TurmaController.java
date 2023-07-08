package br.edu.ficdev.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.edu.ficdev.model.Turma;
import br.edu.ficdev.repository.TurmaRepository;


@Controller
@RequestMapping("/turma")
public class TurmaController {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
    @GetMapping
    public String mostraForm(Turma turma) {
        return "add-turma";
    }
	

    @GetMapping("/lista")
    public ModelAndView listaTurma() {
        ModelAndView modelAndView = new ModelAndView("lista");
        List<Turma> turmas = turmaRepository.findAll();
        modelAndView.addObject("turmas", turmas);
        return modelAndView;
    }


    @PostMapping
    public ModelAndView addTurma(Turma turma) {   
        turmaRepository.save(turma);
        ModelAndView modelAndView = new ModelAndView("add-turma");
        modelAndView.addObject("mensagem", "Salvo com sucesso!");
        return modelAndView;
    }
}
