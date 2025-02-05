package ru.veqveq.renovation.service.dto.work;

import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import lombok.Data;

@Data
public abstract class WorkBaseDto {
  private Long id;

  @JsonInclude(NON_NULL)
  private String name;
}
