package com.kakao.message.template;

import org.json.JSONObject;

public interface TemplateParams {
    String getObjectType();

    JSONObject toJSONObject();
}
