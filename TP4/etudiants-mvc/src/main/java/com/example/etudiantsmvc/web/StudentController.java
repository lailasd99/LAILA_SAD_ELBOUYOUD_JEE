package com.example.etudiantsmvc.web;

import com.example.etudiantsmvc.entities.etudiant;
import com.example.etudiantsmvc.respositories.etudiantRespository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {
    private etudiantRespository etudiantRepository;

    @GetMapping(path = "/user/index")
    public String students(Model model,
                           @RequestParam(name="page", defaultValue = "0") int page,
                           @RequestParam(name="size", defaultValue = "5") int size,
                           @RequestParam(name="keyword", defaultValue = "") String keyword){
        Page<etudiant> pageEtudiants = etudiantRepository.findByNomContains(keyword, PageRequest.of(page,size));
        model.addAttribute("listStudents", pageEtudiants.getContent());
        model.addAttribute("pages", new int[pageEtudiants.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "student";
    }

    @GetMapping("/admin/delete")
    public String delete(Long id, String keyword, int page){
        etudiantRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword"+keyword;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/user/students")
    @ResponseBody
    public List<etudiant> listStudents(){
        return etudiantRepository.findAll();
    }

    @GetMapping("/admin/formStudents")
    public String formPatients(Model model){
        model.addAttribute("student", new etudiant());
        return "formStudents";
    }

    @PostMapping(path="/admin/save")
    public String save(Model model, @Valid etudiant etudiant, BindingResult bindingResult, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "")String keyword){
        if(bindingResult.hasErrors()) return "formStudents";
        etudiantRepository.save(etudiant);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/admin/editStudent")
    public String editPatient(Model model, Long id, String keyword, int page){
        etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        if(etudiant==null) throw new RuntimeException("Etudiant Introuvable");
        model.addAttribute("student", etudiant);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "editStudent";
    }
}
