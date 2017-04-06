package garage.model.dao.converters;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @Converter convertisseur pour JPA à attacher à un attrbut localdate qui va
 *            gérer la conversion des localDate pour que JPA les comprenne.
 * @author mickael
 *
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate paramX) {
		return Date.valueOf(paramX);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date paramY) {
		return paramY.toLocalDate();
	}

}
