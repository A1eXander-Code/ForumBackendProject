package com.forum.forum.dto.resultcode;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum RegistrationCode implements ResultCode {
    REGISTER_SUCCESS, USERNAME_EXISTS;

    @Override
    public String value() {
        return this.name();
    }

    @JsonCreator
    public static RegistrationCode from(String v) {
        return RegistrationCode.valueOf(v);
    }
}
