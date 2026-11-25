package dam.m6.uf2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; 

@Entity 
@Table(name = "Deportes") 
public class Sport {
    
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod")
	int cod;

	@Column(name = "nombre")
	String name;

	public Sport() {}
	
	public Sport(int cod, String name) {
		this.cod = cod;
        this.name = name;
	}
}
