package com.ecommerce.MCA.dto.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerResponse {
    private String name;
    private String email;
    private Date createdAt;
}
