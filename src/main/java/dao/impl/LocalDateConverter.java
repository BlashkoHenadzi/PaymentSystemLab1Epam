package dao.impl;
import java.time.LocalDate;
import org.codehaus.plexus.component.configurator.converters.basic.AbstractBasicConverter;

public class LocalDateConverter extends AbstractBasicConverter {


        public boolean canConvert(Class type) {
            return (type!=null) && LocalDate.class.getPackage().equals(type.getPackage());
        }

        public String toString (Object source) {
            return source.toString();
        }

        public Object fromString(String str) {
            try {
                return LocalDate.parse(str);
            } catch (Exception e) {
                return null;
            }
        }

    }
