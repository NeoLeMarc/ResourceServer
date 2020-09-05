package net.xcore.ressourceserver;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;

@SuppressWarnings("NewClassNamingConvention")
public class RKIDateAndTimeDeserializer extends JsonDeserializer<LocalDateTime> {

  private final SimpleDateFormat dateFormat = new SimpleDateFormat(
      "yyyy/MM/dd HH:mm:ss");

  @SuppressWarnings("DuplicateThrows")
  @Override
  public LocalDateTime deserialize(JsonParser paramJsonParser,
      DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException {
    String str = paramJsonParser.getText().trim();
    try {
      LocalDateTime.from(dateFormat.parse(str).toInstant());
    } catch (ParseException e) {
      // Handle exception here
    }
    return LocalDateTime.from(paramDeserializationContext.parseDate(str).toInstant());
  }
}
