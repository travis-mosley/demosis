package com.sis.demosis.account;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.sis.demosis.account.AccountType;

public class AccountTypeTest {

  @Test
  public void testAccountTypeValues() {
    // test that the values() method returns the expected values
    AccountType[] expectedValues = { AccountType.TEACHER, AccountType.STUDENT };
    AccountType[] actualValues = AccountType.values();
    assertArrayEquals(expectedValues, actualValues);
  }
}
