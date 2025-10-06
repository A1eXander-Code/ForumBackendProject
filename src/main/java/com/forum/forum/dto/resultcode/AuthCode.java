package com.forum.forum.dto.resultcode;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum AuthCode implements ResultCode {
    LOGIN_SUCCESS, INVALID_CREDENTIALS;

    @Override
    public String value() {
        return this.name();
    }

    @JsonCreator
    public static AuthCode from(String v) {
        return AuthCode.valueOf(v);
    }
}
