package com.github.shymega.java.tito_sdk.domain.admin.v3_0;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.shymega.java.tito_sdk.domain.TitoApiBaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@EqualsAndHashCode(callSuper = false)
public final class HelloResponse extends TitoApiBaseModel implements Serializable {
    private boolean authenticated;
    private String access_token;
    private LookupMode lookup_mode;
    private String[] accounts;
}
