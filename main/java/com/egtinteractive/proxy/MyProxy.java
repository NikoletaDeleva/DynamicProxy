package com.egtinteractive.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class MyProxy implements InvocationHandler {
    private final Map<?, ?> map;

    public MyProxy(final Map<?, ?> map) {
	this.map = map;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	method.setAccessible(true);

	System.out.println("Method name: " + method.getName());
	System.out.println("Method start: " + (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS")).format(new Date()));

	final long startTime = System.nanoTime();

	final Object result = method.invoke(map, args);

	final long endTime = System.nanoTime();

	System.out.println("Duration: " + ((double) ((endTime - startTime) / 1000000.0)));
	System.out.println();

	return result;
    }

}
