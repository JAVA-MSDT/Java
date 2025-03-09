package org.dto.converter;

public interface Converter <T, S>{
    T convert(S source);
}
