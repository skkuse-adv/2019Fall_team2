package com.kakao.auth.network;

import com.kakao.common.IConfiguration;
import com.kakao.common.PhaseInfo;
import com.kakao.network.IRequest;

public interface AuthorizedRequest extends IRequest {
    void setAccessToken(String str);

    void setConfiguration(PhaseInfo phaseInfo, IConfiguration iConfiguration);
}
