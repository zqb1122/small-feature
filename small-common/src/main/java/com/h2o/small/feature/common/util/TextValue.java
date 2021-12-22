package com.h2o.small.feature.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * TextValue
 */
@Data
@AllArgsConstructor
public class TextValue implements Serializable {

    private static final long serialVersionUID = 1L;

    private String text;

    private Object value;
}
