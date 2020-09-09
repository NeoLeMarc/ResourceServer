package net.xcore.resourceserver.rki.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RKIDateAndTimeDeserializer extends JsonDeserializer<LocalDateTime> {

  private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(
      "yyyy/MM/dd HH:mm:ss");

  @Override
  public LocalDateTime deserialize(JsonParser paramJsonParser,
      DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException {
    String str = paramJsonParser.getText().trim();
    return LocalDateTime.parse(str, dateFormat);
  }
}
