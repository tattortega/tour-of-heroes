package co.com.sofka.api.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String name;
    private String message;
    private int status;
}
