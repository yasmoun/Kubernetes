package isetn.dsi22.tp5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commandes")
public class RsControllerCommande {
@Autowired
private CommandePetitDejeunerRepository commandeRepository;

@GetMapping(path="/",produces= {MediaType.APPLICATION_JSON_VALUE})

public List<PetitDejeuner> getCommandes(){
	List<PetitDejeuner> commandes= commandeRepository.findAll();
	return commandes;
}
@GetMapping(path="/{id}",produces= {MediaType.APPLICATION_JSON_VALUE})
public PetitDejeuner getOne(@PathVariable Long id){
	return commandeRepository.findById(id).get();
}

@PostMapping(path="/",produces={MediaType.APPLICATION_JSON_VALUE})
public PetitDejeuner save(@RequestBody PetitDejeuner p) {
	return commandeRepository.save(p);
}

@PutMapping (path="/{id}",produces={MediaType.APPLICATION_JSON_VALUE})
public PetitDejeuner update (@RequestBody PetitDejeuner p , @PathVariable Long id) {
	p.setId(id);
	return commandeRepository.save(p);
}

@DeleteMapping (path="/{id}")
public void delete(@PathVariable Long id) {
	commandeRepository.deleteById(id);
}

@GetMapping (path="bycommentaire/{commentaires}",produces={MediaType.APPLICATION_JSON_VALUE})
public List<PetitDejeuner> getByCommentaires(@PathVariable String commentaires){
	return commandeRepository.findByCommentaires(commentaires);
	
}
}
