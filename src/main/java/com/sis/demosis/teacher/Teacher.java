package com.sis.demosis.teacher;

import com.sis.demosis.account.AccountType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

  @NotBlank
  @Size(max = 50)
  @Column(name = "first_name")
  private String firstName;

  @NotBlank
  @Size(max = 50)
  @Column(name = "last_name")
  private String lastName;

  @NotBlank
  @Size(min = 5, max = 5)
  private String employeeId;

  @NotBlank
  @Size(max = 100)
  @Email
  @Column(unique = true)
  private String email;

  @NotBlank
  @Enumerated(EnumType.STRING)
  @Column(name = "account_type")
  private AccountType accountType;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 100)
  private String address;

  @NotBlank
  @Size(min = 10, max = 10)
  private String phoneNumber;
}
