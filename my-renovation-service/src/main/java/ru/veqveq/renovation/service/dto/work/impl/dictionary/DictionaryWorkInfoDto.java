package ru.veqveq.renovation.service.dto.work.impl.dictionary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.veqveq.renovation.service.dto.MeasureUnitDto;
import ru.veqveq.renovation.service.dto.material.impl.dictionary.DictionaryMaterialInfoDto;
import ru.veqveq.renovation.service.dto.work.WorkBaseDto;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DictionaryWorkInfoDto extends WorkBaseDto {
  private MeasureUnitDto unit;
  @JsonInclude(NON_EMPTY)
  private List<DictionaryMaterialInfoDto> materials;
  @JsonInclude(NON_EMPTY)
  private List<DictionaryWorkInfoDto> childWorks;
}
