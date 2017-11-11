package ru.hh.school2017.check;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import ru.hh.school2017.check.data.TestData;

public class ConfigReader {

  public static TestData getTestData() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
    return mapper.readValue(new File("testData.json"), TestData.class);
  }
}
