package com.spartatest.common.dto;

public record MessageResponse(String msg) {

    public static MessageResponse deleteSuccess() {
        return new MessageResponse("삭제완료");
    }
}
