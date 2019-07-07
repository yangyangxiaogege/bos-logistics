package com.bos.utils;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * cxf 工具类
 * @author ASUS
 *
 */
public class CXFUtil {

	/**
	 * 调用服务，获取数据
	 * @param url 服务地址
	 * @param method 要进行访问的服务方法
	 * @param params 请求参数
	 * @return
	 * @throws Exception
	 */
	public static Object invokeWS(String url,String method,Object...params) throws Exception {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		// "http://localhost:8080/service/customer?wsdl"
        Client client = dcf.createClient(url);
        // "findAll"
        Object [] objs = client.invoke(method,params);
        return objs[0];
	}
}
