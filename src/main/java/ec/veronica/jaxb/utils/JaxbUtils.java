package ec.veronica.jaxb.utils;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public final class JaxbUtils {

    private JaxbUtils() {
    }

    public static Jaxb2Marshaller buildMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        final Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(Marshaller.JAXB_ENCODING, StandardCharsets.UTF_8.name());
        properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        properties.put("com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler",
                new CharacterEscapeHandler() {
                    @Override
                    public void escape(char[] ac, int i, int j, boolean flag,
                                       Writer writer) throws IOException {
                        writer.write(ac, i, j);
                    }
                });
        marshaller.setMarshallerProperties(properties);
        return marshaller;
    }

}
