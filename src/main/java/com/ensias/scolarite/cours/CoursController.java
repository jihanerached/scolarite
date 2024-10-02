package com.ensias.scolarite.cours;

import java.util.List;
import java.util.Optional;
import com.ensias.scolarite.modules.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indicating that this is a REST controller
public class CoursController {

    @Autowired // Injecting the CoursService class
    private CoursService coursService;

    @Autowired // Injecting the ModuleService class to fetch modules
    private ModuleService moduleService;

    // Retrieve all courses for a given module
    @RequestMapping("/modules/{id}/cours")
    public List<Cours> getAllCours(@PathVariable Integer id){
        return coursService.getAllCours(id);
    }

    // Retrieve a specific course of a given module
    @RequestMapping("/modules/{moduleId}/cours/{id}")
    public Optional<Cours> getCours(@PathVariable Integer id){
        return coursService.getCours(id);
    }

    // Add a course to a given module
    @RequestMapping(method=RequestMethod.POST, value="/modules/{moduleId}/cours")
    public void ajouterCours(@RequestBody Cours cours, @PathVariable Integer moduleId) {
        // Fetch the module from the database instead of creating a new one
        Module module = moduleService.getModule(moduleId);
        cours.setModule(module); // Set the fetched module to the course
        coursService.ajouterCours(cours);
    }

    // Update a specific course of a given module
    @RequestMapping(method=RequestMethod.PUT, value="/modules/{moduleId}/cours/{id}")
    public void modifierCours(@RequestBody Cours cours, @PathVariable Integer moduleId,
                              @PathVariable Integer id) {
        // Fetch the module from the database instead of creating a new one
        Module module = moduleService.getModule(moduleId);
        cours.setModule(module); // Set the fetched module to the course
        coursService.modifierCours(cours);
    }

    // Delete a specific course from a module
    @RequestMapping(method=RequestMethod.DELETE, value="/modules/{moduleId}/cours/{id}")
    public void supprimerCours(@PathVariable Integer id) {
        coursService.supprimerCours(id);
    }
}
