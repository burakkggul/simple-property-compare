package tr.com.burakgul;

import java.util.Properties;
import java.util.Set;

public class Main {
    private static CompareService compareService = new CompareService();

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("This application needs two parameters. First parameter: cmsProperties Second Parameter: ibeProperties");
            System.out.println("Example usage compareProp.class /home/burak/prop1.properties /home/burak/prop2.properties");
            System.exit(1);
        }
        String mainPropertiesFileAbsolutePath = args[0];
        String toComparePropertiesFileAbsolutePath = args[1];

        Properties cmsProperties = compareService.getProperties(mainPropertiesFileAbsolutePath);
        Properties ibeProperties = compareService.getProperties(toComparePropertiesFileAbsolutePath);

        Set<String> diffProp = compareService.diffProperty(cmsProperties, ibeProperties);
        compareService.writePropertyToFile(diffProp);
    }
}
