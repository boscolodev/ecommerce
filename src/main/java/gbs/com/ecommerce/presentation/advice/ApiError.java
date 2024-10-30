package gbs.com.ecommerce.presentation.advice;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class ApiError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Instant timestamp;
    private Integer status;
    private String error;
    private String mensage;
    private String path;
}
