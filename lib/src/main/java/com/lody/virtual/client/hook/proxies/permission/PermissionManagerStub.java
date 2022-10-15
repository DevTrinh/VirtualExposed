package com.lody.virtual.client.hook.proxies.permission;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import com.lody.virtual.client.hook.base.BinderInvocationProxy;
import com.lody.virtual.client.hook.base.MethodProxy;

import java.lang.reflect.Method;

import mirror.android.permission.IPermissionManager;

/**
 * @author LittleAngry
 * @see android.permission.PermissionManager
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
public class PermissionManagerStub extends BinderInvocationProxy {

    public PermissionManagerStub() {
        super(IPermissionManager.Stub.asInterface, "permissionmgr");
    }

    @Override
    protected void onBindMethods() {
        super.onBindMethods();
        addMethodProxy(new MethodProxy() {
            @Override
            public String getMethodName() {
                return "addOnPermissionsChangeListener";
            }

            @Override
            public Object call(Object who, Method method, Object... args) throws Throwable {
                Log.d("PermissionManager", "addOnPermissionsChangeListener ignored");
                return null;
            }
        });

    }
}
