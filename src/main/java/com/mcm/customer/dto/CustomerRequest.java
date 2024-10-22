package com.mcm.customer.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CustomerRequest(@NotNull(message = "Identification is null")
                              @NotEmpty(message = "Identification is empty")
                              @Size(max = 20, message = "Identification size is not valid")
                              String identification,
                              @NotNull(message = "Name is null")
                              @NotEmpty(message = "Name is empty")
                              @Size(max = 50, message = "Name size is not valid")
                              String name,
                              @NotNull(message = "Lastname is null")
                              @NotEmpty(message = "Lastname is empty")
                              @Size(max = 50, message = "Lastname size is not valid")
                              String lastname) {
}
