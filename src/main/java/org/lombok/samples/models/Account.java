package org.lombok.samples.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true,
        fluent = true, makeFinal = true)
@ToString
public class Account {
    private String accountNumber;
    private String accountHolderName;
    private String accountHolderCountry;
    @Getter(lazy = true)
    private final List<String> lazyGetterField = lazyMethod();

    private List<String> lazyMethod() {
        return List.of("I"," am"," called", "only", "when", "you", "call", "the", "getLazyGetterField()", "method.");
    }
}
