package com.kakao.network.storage;

import com.kakao.network.response.JSONObjectResponse;
import com.kakao.network.response.ResponseBody;
import com.kakao.network.response.ResponseBody.ResponseBodyException;
import com.kakao.network.response.ResponseStringConverter;
import com.kakao.network.storage.ImageInfo.ImageSize;

public class ImageUploadResponse extends JSONObjectResponse {
    private static final String CONTENT_TYPE = "content_type";
    public static final ResponseStringConverter<ImageUploadResponse> CONVERTER = new ResponseStringConverter<ImageUploadResponse>() {
        public ImageUploadResponse convert(String str) throws ResponseBodyException {
            return new ImageUploadResponse(str);
        }
    };
    private static final String HEIGHT = "height";
    private static final String INFOS = "infos";
    private static final String LENGTH = "length";
    private static final String URL = "url";
    private static final String WIDTH = "width";
    private ImageInfo original = getImageInfo(getBody().getBody(INFOS).getBody(ImageSize.ORIGINAL.getValue()));

    public ImageUploadResponse(String str) {
        super(str);
    }

    public ImageInfo getOriginal() {
        return this.original;
    }

    /* access modifiers changed from: 0000 */
    public ImageInfo getImageInfo(ResponseBody responseBody) throws ResponseBodyException {
        ImageInfo imageInfo = new ImageInfo(responseBody.getString("url"), Integer.valueOf(responseBody.getInt(LENGTH)), responseBody.getString(CONTENT_TYPE), Integer.valueOf(responseBody.getInt("width")), Integer.valueOf(responseBody.getInt("height")));
        return imageInfo;
    }
}
