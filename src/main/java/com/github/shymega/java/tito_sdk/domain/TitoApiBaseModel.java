package com.github.shymega.java.tito_sdk.domain;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class TitoApiBaseModel implements Serializable {
    public int httpStatusCode;
}
