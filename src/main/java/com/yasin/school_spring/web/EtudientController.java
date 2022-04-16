package com.yasin.school_spring.web;

import com.yasin.school_spring.Repositories.EtudientRepository;
import com.yasin.school_spring.entities.Etudiant;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class EtudientController {
    EtudientRepository etudientRepository;
    @GetMapping(path = "/user/index")
    public String patient(Model model,
                          @RequestParam(name = "page",defaultValue = "0") int page,
                          @RequestParam(name = "size",defaultValue = "5")int size,
                          @RequestParam(name = "keyword",defaultValue = "")String keyword){
        Page<Etudiant> l = etudientRepository.findByNomContains(keyword, PageRequest.of(page,size));
        model.addAttribute("listEtudients",l.getContent());
        model.addAttribute("pages",new int[l.getTotalPages()]);
        model.addAttribute("current",page);
        model.addAttribute("keyword",keyword);
        return "etudient";
    }

    @RequestMapping(value={"/admin/delete/{id}/{page}/{keyword}","/admin/delete/{id}/{page}"}, method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id,@PathVariable int page,@PathVariable(required = false) String keyword){
        etudientRepository.deleteById(id);
        if (keyword == null) {
            keyword="";
        }
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping( "/")
    public String home(){
        return "home";
    }
    @GetMapping( "/admin/formEtudient")
    public String formPatients (Model model){
        model.addAttribute("etudient", new Etudiant());
        return "formEtudient";
    }
    @PostMapping(path ="/admin/save")
    public String save (Model model, @Valid Etudiant etudiant, BindingResult bindingResult,
                        @RequestParam(defaultValue = "") String keyword,
                        @RequestParam(defaultValue = "0")int page) {
        if (bindingResult.hasErrors()){
            return "formEtudient" ;
        }
        System.out.println("****************************************************************************");
        System.out.println(etudiant.toString());
        System.out.println("****************************************************************************");
        etudientRepository.save(etudiant);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping( "/admin/editEtudient")
    public String editPatient (Model model,Long id,String keyword,int page){
        Etudiant etudiant = etudientRepository.findById(id).orElse(null);
        if (etudiant==null){
            throw new RuntimeException("etudiant dosnt exist");
        }
        model.addAttribute("etudient", etudiant);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "editEtudient";
    }
}
