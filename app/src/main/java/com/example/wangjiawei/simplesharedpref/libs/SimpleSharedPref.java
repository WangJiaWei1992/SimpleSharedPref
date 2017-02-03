package com.example.wangjiawei.simplesharedpref.libs;

import com.example.wangjiawei.simplesharedpref.libs.core.ServiceMethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by WangJiaWei on 2017/2/3.
 */

public class SimpleSharedPref {

    private ISharedPref mDelegate;
    private final Map<Method, ServiceMethod> mServiceMethodCache = new LinkedHashMap<>();

    private SimpleSharedPref() {
        mDelegate = create(ISharedPref.class);
    }

    private static class InstanceHolder{
        private static final SimpleSharedPref instance = new SimpleSharedPref();
    }

    public static SimpleSharedPref getIns(){
        return InstanceHolder.instance;
    }

    public static ISharedPref getService() {
        return getIns().mDelegate;
    }

    @SuppressWarnings("unchecked")
    private <T> T create(final Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object... args)
                            throws Throwable {
                        if (method.getDeclaringClass() == Object.class) {
                            return method.invoke(this, args);
                        }
                        ServiceMethod serviceMethod = loadServiceMethod(method);
                        return null;//serviceMethod.callAdapter.adapt(okHttpCall);
                    }
                });
    }

    private ServiceMethod loadServiceMethod(Method method) {
        ServiceMethod result;
        synchronized (mServiceMethodCache) {
            result = mServiceMethodCache.get(method);
            if (result == null) {
                result = new ServiceMethod.Builder(method).build();
                mServiceMethodCache.put(method, result);
            }
        }
        return result;
    }
}
