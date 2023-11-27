package org.lombok.samples.models;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


@ToString(includeFieldNames = false, callSuper = true, onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Setter
@Accessors(chain = true,
        fluent = true, makeFinal = true)
public class BusinessAccount extends Account_ToString_EqualsHashCode_Annotation {

    @ToString.Include
    private String companyName;
}
