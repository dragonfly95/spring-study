package com.example.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(value = Include.ALWAYS)
public class RequestVO implements Serializable {


  private static final long serialVersionUID = -8714723177416740232L;


}
