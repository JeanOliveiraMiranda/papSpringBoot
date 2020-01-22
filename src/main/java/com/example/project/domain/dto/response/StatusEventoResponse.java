package com.example.project.domain.dto.response;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusEventoResponse {

    @NotEmpty(message = "NomeStatus is required")
    private String NomeStatus;

    @NotEmpty(message = "IdEventoStatus status is required")
    private String IdEventoStatus;

}