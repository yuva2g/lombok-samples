package org.lombok.samples.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Getter
@Builder(builderClassName = "Builder",
        builderMethodName = "newAccount",
        buildMethodName = "create",
        setterPrefix = "with")
@ToString
public class Account_BuilderAnnotation {
    private String accountNumber;
    private String accountHolderName;
    @lombok.Builder.Default
    private String accountHolderCountry = "NL";
    @Singular
    private List<String> addresses;
}
