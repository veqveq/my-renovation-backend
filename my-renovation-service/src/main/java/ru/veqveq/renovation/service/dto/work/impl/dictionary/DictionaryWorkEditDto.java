package ru.veqveq.renovation.service.dto.work.impl.dictionary;

import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.veqveq.renovation.service.dto.material.impl.dictionary.DictionaryMaterialEditDto;
import ru.veqveq.renovation.service.dto.work.WorkBaseDto;

@Data
@EqualsAndHashCode(callSuper = true)
public class DictionaryWorkEditDto extends WorkBaseDto {
  private String unitCode;
  @JsonInclude(NON_EMPTY)
  private List<DictionaryMaterialEditDto> materials;
  @JsonInclude(NON_EMPTY)
  private List<DictionaryWorkEditDto> childWorks;
}
