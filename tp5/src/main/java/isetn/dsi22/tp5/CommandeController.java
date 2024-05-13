package isetn.dsi22.tp5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;


@Controller
public class CommandeController {
@Autowired 
	private CommandePetitDejeunerRepository commandeRepository;
@GetMapping("/formulaire")
public String afficherFormulaire(Model model) {
model.addAttribute("commande", new PetitDejeuner());
return "formulaire";
}
@PostMapping("/commande")
public String traiterCommande(@ModelAttribute("commande")
@Valid PetitDejeuner commande,BindingResult result, Model model) {
	 if (result.hasErrors()) {
	        return "formulaire";
	    } else {
	        model.addAttribute("commande", commande);
	        commandeRepository.save(commande); 
	        return "recapitulatif";
	    }
}

}
