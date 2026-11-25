package dam.m6.uf2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Deportistas") 
public class Sportman implements java.io.Serializable {

    @Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod")
    int cod;

    @Column(name = "nombre")
    String name;

    @Column(name = "cod_deporte")
    int cod_sport;

    public Sportman() {}

    public Sportman(int cod, String name, int cod_sport) {
        this.cod = cod;
        this.name = name;
        this.cod_sport = cod_sport;
    }
}
