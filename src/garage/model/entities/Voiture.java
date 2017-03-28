package garage.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import garage.model.entities.validation.PastDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "id" })
// attention avec Lombok le toString fait des + à la place des buffers
@ToString
// constructeur vide de bean
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class Voiture implements Serializable {

	@Getter
	UUID id;
	@Getter
	@Setter
	@PastDate(message="La date est forcément passée.")
	LocalDate miseEnCirculation;
	@Getter
	@Setter
	String modele;
	@Getter
	@Setter
	@Min(value=0, message="La puissance est forcement positive.")
	int puissance;
	@Getter
	@Setter
	@Pattern(regexp="[A-Z]{2}-\\d{3}-[A-Z]{2}", message="L'immat doit être de la forme AA-123-BB.")
	String immatriculation;

}
