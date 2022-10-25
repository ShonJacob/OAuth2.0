package com.shonjacob.oauth.ResourceServer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserRest {
    private String userFirstName;
    private String userLastName;
    private String userId;
}
