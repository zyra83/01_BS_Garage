package garage.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

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
	LocalDate miseEnCirculation;
	@Getter
	@Setter
	String modele;
	@Getter
	@Setter
	int puissance;
	@Getter
	@Setter
	String immatriculation;

}
