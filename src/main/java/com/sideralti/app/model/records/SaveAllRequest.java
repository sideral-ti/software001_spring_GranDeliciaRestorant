package com.sideralti.app.model.records;

import com.sideralti.app.model.dto.MesaDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "SaveAllRequest")
record SaveAllRequest(
        @Schema(description = "List of mesas to create")
        List<MesaDTO> mesas
) {}