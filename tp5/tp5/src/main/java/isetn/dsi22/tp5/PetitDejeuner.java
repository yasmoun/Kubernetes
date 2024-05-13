package isetn.dsi22.tp5;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="petit_dejeuner")
public class PetitDejeuner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Min(value=1,message=" Le numéro de chambre doit être supérieur à 0")
	@Column(name = "chambre")
	private int chambre;
	@Min(value=1,message="Le nombre de repas doit être entre 1 et 10") @Max(value=10,message="Le nombre de repas doit être entre 1 et 10")
	@Column(name = "nombreDeRepas")
	private int nombreDeRepas;
	@Pattern(regexp = "(0[6-9]|1[0])[:][0-5][0-9]", message = "L'heure doit être comprise entre 06:00 et 10:59")
	@Column(name = "heure")
	private String heure;
	@NotEmpty(message = "Le champ des commentaires ne peut pas être vide")
	@Column(name = "commentaires")
	private String commentaires;
	
	public PetitDejeuner() {
		super();
		// TODO Auto-generated constructor stub
		}
    public PetitDejeuner(int chambre, int nombreDeRepas, String heure, String commentaires) {
		super();
		this.chambre = chambre;
		this.nombreDeRepas = nombreDeRepas;
		this.heure = heure;
		this.commentaires = commentaires;
	}


	@Override
	public String toString() {
		return "PetitDejeuner [chambre=" + chambre + ", nombreDeRepas=" + nombreDeRepas + ", heure=" + heure
				+ ", commentaires=" + commentaires + "]";
	}


	public int getChambre() {
		return chambre;
	}


	public int getNombreDeRepas() {
		return nombreDeRepas;
	}


	public String getHeure() {
		return heure;
	}


	public String getCommentaires() {
		return commentaires;
	}



	public void setChambre(int chambre) {
		this.chambre = chambre;
	}


	public void setNombreDeRepas(int nombreDeRepas) {
		this.nombreDeRepas = nombreDeRepas;
	}


	public void setHeure(String heure) {
		this.heure = heure;
	}


	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	public void setId(Long id) {
		this.id=id;
	}
	

	
	
}


