package isetn.dsi22.tp5;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandePetitDejeunerRepository extends JpaRepository<PetitDejeuner, Long>{

	List<PetitDejeuner> findByCommentaires(String commentaires);

}
