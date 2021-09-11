package org.school.entity.Coverters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Year;
import java.util.logging.Logger;

@Converter(autoApply = true)
public class YearConverter implements AttributeConverter<Year, Short> {

    Logger log = Logger.getLogger(YearConverter.class.getSimpleName());

    @Override
    public Short convertToDatabaseColumn(Year attribute) {
        short year = (short) attribute.getValue();
        log.info("Convert Year ["+attribute+"] to short ["+year+"]");
        return year;
    }

    @Override
    public Year convertToEntityAttribute(Short dbValue) {
        Year year = Year.of(dbValue);
        log.info("Convert Short ["+dbValue+"] to Year ["+year+"]");
        return year;
    }
}