package gr.test;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Clazz {
    @NotNull(message = "{com.test.lang}")
    @NotBlank(message = "{com.test.lang}")
    public String notNullEmptyField;
}
