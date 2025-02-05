package ru.veqveq.renovation.service.dto.material.impl.dictionary;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.veqveq.renovation.service.dto.material.MaterialBaseDto;

@Data
@EqualsAndHashCode(callSuper = true)
public class DictionaryMaterialEditDto extends MaterialBaseDto {
  private String unitCode;
}
