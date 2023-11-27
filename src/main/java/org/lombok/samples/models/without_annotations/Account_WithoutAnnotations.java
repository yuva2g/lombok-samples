package org.lombok.samples.models.without_annotations;

import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

public class Account_WithoutAnnotations {
    private String accountNumber;
    private String accountHolderName;
    private String accountHolderCountry;

    @Override
    public String toString() {
        return "Account_WithoutAnnotations{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountHolderCountry='" + accountHolderCountry + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account_WithoutAnnotations that = (Account_WithoutAnnotations) o;
        return Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    public Account_WithoutAnnotations(String accountNumber, String accountHolderName, String accountHolderCountry) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountHolderCountry = accountHolderCountry;
    }

    public Account_WithoutAnnotations() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountHolderCountry() {
        return accountHolderCountry;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setAccountHolderCountry(String accountHolderCountry) {
        this.accountHolderCountry = accountHolderCountry;
    }
}
