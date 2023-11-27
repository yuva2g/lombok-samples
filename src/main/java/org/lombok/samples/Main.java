package org.lombok.samples;

import lombok.extern.slf4j.Slf4j;
import org.lombok.samples.models.Account;
import org.lombok.samples.models.Account_BuilderAnnotation;
import org.lombok.samples.models.BusinessAccount;
import org.lombok.samples.models.without_annotations.Account_WithoutAnnotations;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {

        sampleForBuilderAnnotation();

        sampleForBuilderWithSingularAnnotation();

        sampleForSetterWithAccessorAnnotation();

        sampleForToStringAnnotation();

        sampleForEqualsAndHashCodeAnnotation();

        // More samples coming soon...
    }

    private static void sampleForBuilderAnnotation() {

        Account_BuilderAnnotation account = Account_BuilderAnnotation.newAccount()
                // Builder annotation with default value ("NL") is already set in Account_BuilderAnnotation.java
                // .withAccountHolderCountry("USA")
                .withAccountHolderName("John")
                .withAccountNumber("NL012345")
                .create();
        log.info("Account with Builder Annotation: {}", account);
        // Output: Account with Builder Annotation: Account_BuilderAnnotation(accountNumber=NL012345, accountHolderName=John, accountHolderCountry=NL, addresses=null)
    }

    private static void sampleForBuilderWithSingularAnnotation() {
        Account_BuilderAnnotation.Builder accountBuilder = Account_BuilderAnnotation.newAccount()
                .withAccountHolderName("John")
                .withAccountNumber("NL012345");

        // @Singular annotation is used to add one element at a time to the collection
        accountBuilder.withAddress("Address 1");
        // Also clear method is available to clear the collection
        accountBuilder.clearAddresses();
        // Also, we can add multiple elements at a time to the collection
        accountBuilder.withAddresses(List.of("Address 2", "Address 3"));

        Account_BuilderAnnotation account = accountBuilder.create();

        log.info("Account with Builder and Singular Annotation: {}", account);
        // Output: Account with Builder and Singular Annotation: Account_BuilderAnnotation(accountNumber=NL012345, accountHolderName=John, accountHolderCountry=NL, addresses=[Address 2, Address 3])
    }

    private static void sampleForSetterWithAccessorAnnotation() {

        // Code without lombok annotations
        Account_WithoutAnnotations accountWithoutAnnotations = new Account_WithoutAnnotations();
        accountWithoutAnnotations.setAccountNumber("1234567890");
        accountWithoutAnnotations.setAccountHolderName("John Doe");
        accountWithoutAnnotations.setAccountHolderCountry("USA");

        log.info("Account without Annotations: {}", accountWithoutAnnotations);
        // Output: Account without Annotations: Account_WithoutAnnotations{accountNumber='1234567890', accountHolderName='John Doe', accountHolderCountry='USA'}

        // Code with lombok annotations @Setter @Accessors with their attributes
        Account account = new Account();
        account.accountNumber("1234567890")
            .accountHolderName("John Doe")
            .accountHolderCountry("NL");

        log.info("Account with Setter Annotation: {}", account);
        // Output: Account with Setter Annotation: Account(accountNumber=1234567890, accountHolderName=John Doe, accountHolderCountry=NL)
        log.info("Calling a lazy getter: {}", account.lazyGetterField());
        // Output: Calling a lazy getter: [I,  am, called, only, when, you, call, the, getLazyGetterField(), method.]
    }

    private static void sampleForToStringAnnotation() {

        BusinessAccount businessAccount = new BusinessAccount();
        businessAccount.companyName("ABC Company")
                .accountNumber("1234567890")
                .accountHolderName("John Doe")
                .accountHolderCountry("USA");

        log.info("Business Account with ToString: {}", businessAccount);
        // Output: Business Account: BusinessAccount(super=Account_ToString_EqualsHashCode_Annotation(John Doe), ABC Company)
     }

    private static void sampleForEqualsAndHashCodeAnnotation() {
        BusinessAccount businessAccount0 = new BusinessAccount();
        businessAccount0.companyName("ABC Company")
                .accountNumber("1234567890")
                .accountHolderName("John Doe")
                .accountHolderCountry("USA");

        BusinessAccount businessAccount1 = new BusinessAccount();
        businessAccount1.companyName("ABC Company")
                .accountNumber("1234567890")
                .accountHolderName("John Doe")
                .accountHolderCountry("USA");

        // Because EqualsAndHashCode annotation is used with onlyExplicitlyIncluded = true,
        // and works only on the fields that are annotated with @EqualsAndHashCode.Include
        // which is only accountNumber in this case
        log.info("Business Account 0 {}equal to Business Account 1", businessAccount0.equals(businessAccount1) ? "" : "not ");

        BusinessAccount businessAccount2 = new BusinessAccount();
        businessAccount2.companyName("ABC Company")
                .accountNumber("9876543210")
                .accountHolderName("John Doe")
                .accountHolderCountry("USA");

        // Because EqualsAndHashCode annotation is used with onlyExplicitlyIncluded = true,
        // and works only on the fields that are annotated with @EqualsAndHashCode.Include
        // which is only accountNumber in this case
        log.info("Business Account 1 {}equal to Business Account 2", businessAccount1.equals(businessAccount2) ? "" : "not ");
    }
}