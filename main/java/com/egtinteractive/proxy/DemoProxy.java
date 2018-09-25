package com.egtinteractive.proxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class DemoProxy {
    public static void main(String[] args) {
	Map<String, Integer> map = new HashMap<>();
	@SuppressWarnings("unchecked")
	Map<String, Integer> proxyMap = (Map<String, Integer>) Proxy.newProxyInstance(DemoProxy.class.getClassLoader(),
		new Class[] { Map.class }, new MyProxy(map));

	proxyMap.put("One", 1);
	proxyMap.put("Two", 2);
	proxyMap.put("Three", 3);
	proxyMap.remove("One");
	proxyMap.containsKey("Two");
	System.out.println(proxyMap.get("Three"));
    }
}
