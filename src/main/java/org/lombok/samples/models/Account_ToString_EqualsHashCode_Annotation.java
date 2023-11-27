package org.lombok.samples.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString(includeFieldNames = false,
        onlyExplicitlyIncluded = true,
        doNotUseGetters = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true,
        doNotUseGetters = true)
@Setter
@Getter
@Accessors(chain = true,
        fluent = true, makeFinal = true)
public class Account_ToString_EqualsHashCode_Annotation {

    @EqualsAndHashCode.Include
    private String accountNumber;
    @ToString.Include
    private String accountHolderName;
    private String accountHolderCountry;
}
