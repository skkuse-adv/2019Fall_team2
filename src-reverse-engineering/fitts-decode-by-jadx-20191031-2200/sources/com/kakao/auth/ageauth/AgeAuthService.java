package com.kakao.auth.ageauth;

import android.content.Context;
import android.os.Bundle;

public interface AgeAuthService {
    int requestAgeAuth(Bundle bundle, Context context);
}
