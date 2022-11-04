package com.simbirsoft.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LombokUserData {
    @JsonProperty("success")
    private boolean success;
    private String message;
    @JsonProperty("updatetopcartsectionhtml")
    private String updatetopcart;
    @JsonProperty("updateflyoutcartsectionhtml")
    private String updateflyoutcartsectionhtm;
}
