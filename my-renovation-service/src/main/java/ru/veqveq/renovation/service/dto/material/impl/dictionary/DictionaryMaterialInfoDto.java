package ru.veqveq.renovation.service.dto.material.impl.dictionary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.veqveq.renovation.service.dto.MeasureUnitDto;
import ru.veqveq.renovation.service.dto.material.MaterialBaseDto;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DictionaryMaterialInfoDto extends MaterialBaseDto {
  private MeasureUnitDto unit;
}
