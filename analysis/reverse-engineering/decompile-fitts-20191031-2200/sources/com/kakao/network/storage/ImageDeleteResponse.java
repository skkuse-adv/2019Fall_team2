package com.kakao.network.storage;

import com.kakao.network.response.ResponseBody.ResponseBodyException;
import com.kakao.network.response.ResponseStringConverter;

public class ImageDeleteResponse {
    public static final ResponseStringConverter<ImageDeleteResponse> CONVERTER = new ResponseStringConverter<ImageDeleteResponse>() {
        public ImageDeleteResponse convert(String str) throws ResponseBodyException {
            return new ImageDeleteResponse();
        }
    };

    ImageDeleteResponse() {
    }
}
