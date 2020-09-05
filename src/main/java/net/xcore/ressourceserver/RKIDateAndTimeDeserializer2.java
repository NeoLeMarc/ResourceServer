package net.xcore.ressourceserver;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RKIDateAndTimeDeserializer2 extends JsonDeserializer<LocalDateTime> {

  private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(
      "dd.MM.yyyy, HH:mm");
  Logger logger = LoggerFactory.getLogger(RKIDateAndTimeDeserializer2.class);

  @Override
  public LocalDateTime deserialize(JsonParser paramJsonParser,
      DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException {
    String str = paramJsonParser.getText().trim().replace(" Uhr", "");
    return LocalDateTime.parse(str, dateFormat);
  }
}
