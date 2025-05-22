package com.food.delivery.system.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@RequiredArgsConstructor
public enum EventType {

    AAA(EventPayload.class, "aaa")

    ;

    private final Class<? extends EventPayload> payloadClass;
    private final String topic;


    public static EventType from(String type) {
        try {
            return valueOf(type);
        } catch (Exception e) {
//            log.error("[EventType.from] type={}", type, e);
            return null;
        }
    }

    public static class Topic {
        public static final String KUKE_BOARD_ARTICLE = "kuke-board-article";
        public static final String KUKE_BOARD_COMMENT = "kuke-board-comment";
        public static final String KUKE_BOARD_LIKE = "kuke-board-like";
        public static final String KUKE_BOARD_VIEW = "kuke-board-view";
    }
}
