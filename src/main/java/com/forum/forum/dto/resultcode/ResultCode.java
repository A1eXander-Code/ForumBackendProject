package com.forum.forum.dto.resultcode;

import com.fasterxml.jackson.annotation.JsonValue;

public interface ResultCode {
    @JsonValue 
    String value();  // how it appears on the wire (JSON)
}