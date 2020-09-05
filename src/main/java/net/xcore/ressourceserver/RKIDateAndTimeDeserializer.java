package net.xcore.ressourceserver;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

@SuppressWarnings("NewClassNamingConvention")
public class RKIDateAndTimeDeserializer extends JsonDeserializer<Instant> {

  private final SimpleDateFormat dateFormat = new SimpleDateFormat(
      "yyyy/MM/dd HH:mm:ss");

  @SuppressWarnings("DuplicateThrows")
  @Override
  public Instant deserialize(JsonParser paramJsonParser,
      DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException {
    String str = paramJsonParser.getText().trim();
    try {
      return dateFormat.parse(str).toInstant();
    } catch (ParseException e) {
      // Handle exception here
    }
    return paramDeserializationContext.parseDate(str).toInstant();
  }
}
