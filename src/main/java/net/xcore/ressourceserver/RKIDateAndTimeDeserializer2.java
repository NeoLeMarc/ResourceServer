package net.xcore.ressourceserver;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RKIDateAndTimeDeserializer2 extends JsonDeserializer<LocalDateTime> {

  private final SimpleDateFormat dateFormat = new SimpleDateFormat(
      "dd.MM.yyyy, HH:mm");

  Logger logger = LoggerFactory.getLogger(RKIDateAndTimeDeserializer2.class);

  @Override
  public LocalDateTime deserialize(JsonParser paramJsonParser,
      DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException {
    String str = paramJsonParser.getText().trim().replace(" Uhr", "");
    try {
      return LocalDateTime.from(dateFormat.parse(str).toInstant());
    } catch (ParseException e) {
      logger.error(String.valueOf(e));
    }
    return LocalDateTime.from(paramDeserializationContext.parseDate(str).toInstant());
  }
}
