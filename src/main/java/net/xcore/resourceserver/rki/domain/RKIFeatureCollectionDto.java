package net.xcore.resourceserver.rki.domain;

import java.util.List;

@SuppressWarnings({"FieldNamingConvention", "NewClassNamingConvention"})
public class RKIFeatureCollectionDto {
  public List<RKIFeatureDto> features;
  public String type;
  public String name;

  public RKIFeatureCollectionDto() {
  }
}
