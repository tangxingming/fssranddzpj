package com.youchu.fssranddzpj.service.fabriclistener;


import org.yaml.snakeyaml.Yaml;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class Configurations {

    public JsonObject loadConfigurations() throws FileNotFoundException {
        String configPath = "config.yml";
        InputStream stream = Configurations.class.getClassLoader().getResourceAsStream(configPath);
        Yaml yaml = new Yaml();
        Map<String,Object> configYaml = yaml.load(stream);
        JsonObject configJSON = Json.createObjectBuilder(configYaml).build();
        return configJSON;
    }

}
