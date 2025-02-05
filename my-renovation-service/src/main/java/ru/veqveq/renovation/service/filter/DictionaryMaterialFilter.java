package ru.veqveq.renovation.service.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DictionaryMaterialFilter {
  private String name;
  private boolean exactMatch;
}
