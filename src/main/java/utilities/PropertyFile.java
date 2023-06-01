package utilities;

import constants.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
    private PropertyFile(){
    }

    public static String getProperty(String key) throws IOException {
        FileInputStream fileInput = new FileInputStream(Constants.PROPERTY_FILE_PATH);
        Properties prop = new Properties();
        prop.load(fileInput);
        return prop.getProperty(key);
    }
}
