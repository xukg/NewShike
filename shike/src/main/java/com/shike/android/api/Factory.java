package com.shike.android.api;

import com.android.core.api.HttpClient;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    public static BaseHttpService provideHttpService() {
        return provideService(BaseHttpService.class);
    }

    private static Map<Class, Object> m_service = new HashMap();

    private static <T> T provideService(Class cls) {
        Object serv = m_service.get(cls);
        if (serv == null) {
            synchronized (cls) {
                serv = m_service.get(cls);
                if (serv == null) {
                    serv = HttpClient.getIns(ApiConstant.BASE_URL).createService(cls);
                    m_service.put(cls, serv);
                }
            }
        }
        return (T) serv;
    }
}
