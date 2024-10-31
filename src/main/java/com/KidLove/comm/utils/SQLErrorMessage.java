package com.KidLove.comm.utils;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SQLErrorMessage {

    // SQL 에러 메시지 추출 메서드
    public String extractSqlErrorMessage(String message) {
        if (message == null || message.isEmpty()) {
            return "No error message found";
        }
        
        log.info(message);
        
        // '### SQL:' 부터 시작하는 구문 추출
        int sqlStartIndex = message.indexOf("### SQL:");
        int causeStartIndex = message.indexOf("### Cause:");

        if (causeStartIndex != -1) {
            // 'Cause:' 다음의 메시지를 가져오기 위해 시작 인덱스 조정
            int causeMessageStartIndex = causeStartIndex + "### Cause:".length();
            return message.substring(causeMessageStartIndex).trim(); // Cause 메시지 반환
        }
        
        return "No SQL error message found";
    }
}
