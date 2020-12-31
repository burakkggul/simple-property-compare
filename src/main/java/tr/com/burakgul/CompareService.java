package tr.com.burakgul;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class CompareService {
    public CompareService() {
    }

    protected Set<String> diffProperty(Properties mainProperties, Properties toCompareProperties) {
        Set<String> mainPropertySet = mainProperties.stringPropertyNames();
        Set<String> toComparePropertySet = toCompareProperties.stringPropertyNames();

        mainPropertySet.removeAll(toComparePropertySet);
        return mainPropertySet;
    }

    protected void writePropertyToFile(Set<String> mainPropertySet) {
        try {
            FileWriter writer = new FileWriter("differentKey.txt");
            System.out.println("****************************************");
            System.out.println("Different Key List:(differentKey.txt)");
            for (String property : mainPropertySet) {
                System.out.println(property);
                writer.write(property + System.lineSeparator());
            }
            System.out.println("*******************************************");
            writer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    protected Properties getProperties(String absolutePath) {
        Properties properties = new Properties();
        try {
            InputStream inputstream = new FileInputStream(absolutePath);
            properties.load(inputstream);
        } catch (Exception e) {
            System.out.println("File Not Found");
            System.exit(1);
        }
        return properties;
    }
}
