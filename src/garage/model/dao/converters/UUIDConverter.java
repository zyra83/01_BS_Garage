package garage.model.dao.converters;

import java.util.UUID;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @Converter convertisseur pour JPA à attacher à un attrbut UUID qui va gérer
 *            la conversion des UUID pour que JPA les comprenne.
 * @author mickael
 *
 */
@Converter(autoApply = true)
public class UUIDConverter implements AttributeConverter<UUID, String> {

	@Override
	public String convertToDatabaseColumn(UUID arg0) {
		return arg0.toString();
	}

	@Override
	public UUID convertToEntityAttribute(String arg0) {
		return UUID.fromString(arg0);
	}

}
