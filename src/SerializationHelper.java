import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;

public class SerializationHelper {

    public static String serializeAsYAML(Serializable object) throws YamlException {

        StringWriter sw = new StringWriter();
        YamlWriter yaml = new YamlWriter(sw);
        yaml.write(object);
        yaml.close();

        return sw.toString();
    }

    public static String serializeAsJSON(Serializable object) {

        Gson gson = new Gson();

        return gson.toJson(object);
    }

    public static String serializeAsJSONPretty(Serializable object) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(object);
    }

    public static String serializeAsXMLPretty(Serializable object) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XMLEncoder encoder = new XMLEncoder(baos);

        encoder.writeObject(object);
        encoder.close();

        String result = new String(baos.toByteArray());
        baos.close();

        return result;
    }

    public static String serializeAsXML(Serializable object) throws IOException {

        String result = serializeAsXMLPretty(object);

        return result.replace("  ", "").replace("\n ", "").replace("\n","");
    }

}
