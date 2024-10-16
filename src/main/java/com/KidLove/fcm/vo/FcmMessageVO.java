package com.KidLove.fcm.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


/**
 * FCM 전송 Format
 */

@Getter
@Builder
public class FcmMessageVO {
    private boolean validateOnly;           
    private FcmMessageVO.Message message;

    @Builder
    @AllArgsConstructor
    @Getter
    public static class Message {
        private FcmMessageVO.Notification notification;
        private String token;
    }

    @Builder
    @AllArgsConstructor
    @Getter
    public static class Notification {
        private String title;
        private String body;
        private String image;
    }
}
