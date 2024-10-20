package com.example.demu.domain.user.controller.dto;

import com.example.demu.domain.user.domain.type.Major;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateMajorRequest {

    private Major major;
}
