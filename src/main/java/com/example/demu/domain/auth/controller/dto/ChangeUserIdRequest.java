package com.example.demu.domain.auth.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChangeUserIdRequest {

    private String accountId;
}
