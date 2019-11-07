package com.kakao.network.storage;

import android.net.Uri.Builder;
import com.kakao.common.IConfiguration;
import com.kakao.common.PhaseInfo;
import com.kakao.network.ApiRequest;
import com.kakao.network.ServerProtocol;
import com.kakao.network.multipart.FilePart;
import com.kakao.network.multipart.Part;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.List;
import java.util.Map;

public class ImageUploadRequest extends ApiRequest {
    private File imageFile;
    private Boolean secureResource;

    public String getMethod() {
        return HttpRequest.METHOD_POST;
    }

    protected ImageUploadRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, Boolean bool, File file) {
        super(phaseInfo, iConfiguration);
        this.secureResource = bool;
        this.imageFile = file;
    }

    public Builder getUriBuilder() {
        Builder authority = super.getUriBuilder().authority(ServerProtocol.apiAuthority());
        if (this.secureResource.booleanValue()) {
            authority.appendQueryParameter("secure_resource", String.valueOf(this.secureResource));
        }
        return authority;
    }

    public Map<String, String> getParams() {
        return super.getParams();
    }

    public List<Part> getMultiPartList() {
        List<Part> multiPartList = super.getMultiPartList();
        File file = this.imageFile;
        if (file != null && file.exists()) {
            multiPartList.add(new FilePart("file", this.imageFile));
        }
        return multiPartList;
    }
}
