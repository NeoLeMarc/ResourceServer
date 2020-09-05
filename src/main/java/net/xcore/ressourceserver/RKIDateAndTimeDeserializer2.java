package net.xcore.ressourceserver;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("NewClassNamingConvention")
public class RKIDateAndTimeDeserializer2 extends JsonDeserializer<Instant> {

  private final SimpleDateFormat dateFormat = new SimpleDateFormat(
      "dd.MM.yyyy, HH:mm");

  Logger logger = LoggerFactory.getLogger(RKIDateAndTimeDeserializer2.class);

  @SuppressWarnings("DuplicateThrows")
  @Override
  public Instant deserialize(JsonParser paramJsonParser,
      DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException {
    String str = paramJsonParser.getText().trim().replace(" Uhr", "");
    try {
      return dateFormat.parse(str).toInstant();
    } catch (ParseException e) {
      logger.error(String.valueOf(e));
    }
    return paramDeserializationContext.parseDate(str).toInstant();
  }
}
