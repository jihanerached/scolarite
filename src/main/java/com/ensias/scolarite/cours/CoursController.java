package com.ensias.scolarite.cours;

import java.util.List;
import java.util.Optional;
import com.ensias.scolarite.modules.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CoursController {

    @Autowired
    private CoursService coursService;

    @RequestMapping("/modules/{moduleId}/cours")
    public List<Cours> getAllCours(@PathVariable Integer moduleId) {
        return coursService.getAllCours(moduleId);
    }

    @RequestMapping("/modules/{moduleId}/cours/{id}")
    public ResponseEntity<Cours> getCours(@PathVariable Integer id) {
        Optional<Cours> cours = coursService.getCours(id);
        if (cours.isPresent()) {
            return ResponseEntity.ok(cours.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modules/{moduleId}/cours")
    public void ajouterCours(@RequestBody Cours cours, @PathVariable Integer moduleId) {
        cours.setModule(new Module(moduleId, "", ""));
        coursService.ajouterCours(cours);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/modules/{moduleId}/cours/{id}")
    public void modifierCours(@RequestBody Cours cours, @PathVariable Integer moduleId, @PathVariable Integer id) {
        cours.setModule(new Module(moduleId, "", ""));
        cours.setId(id); // Ensure the course id is set to the correct id
        coursService.modifierCours(cours);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/modules/{moduleId}/cours/{id}")
    public void supprimerCours(@PathVariable Integer id) {
        coursService.supprimerCours(id);
    }
}
