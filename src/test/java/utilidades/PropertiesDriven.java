package utilidades;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDriven {

    private Properties properties;

    public String obtenerUnaProperties(String key) {

        //instanciar un objeto
        properties = new Properties();

        try {
            InputStream input = new FileInputStream("C:\\Users\\crown\\Desktop\\Trabajos de Repaso\\PageObjectModel\\src\\test\\resources\\Setup.properties");
            properties.load(input);

        } catch (Exception e) {
            System.out.println("no fue posible llamar al archivo properties");
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }


}
