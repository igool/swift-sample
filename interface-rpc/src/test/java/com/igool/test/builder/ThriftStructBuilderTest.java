/**
 * 
 */
package com.igool.test.builder;

import com.igool.test.ICommonUserService;
import com.igool.test.file.service.thrift.FileService;
import com.sohu.thrift.generator.builder.ThriftFileBuilder;
import com.sohu.thrift.generator.utils.ParameterNameDiscoverer;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author hongliuliao
 *
 * createTime:2012-12-6 下午3:24:05
 */
public class ThriftStructBuilderTest {
	private static final ParameterNameDiscoverer parameterNameDiscoverer = new ParameterNameDiscoverer();
	private ThriftFileBuilder fileBuilder = new ThriftFileBuilder();
	
	@Test
	public void toOutputstream() throws Exception {
		this.fileBuilder.buildToOutputStream(ICommonUserService.class, System.out);
		this.fileBuilder.buildToOutputStream(FileService.class, System.out);
	}

	@Test
	public void testParam(){
		Method[] methods = ICommonUserService.class.getDeclaredMethods();
		for (Method method : methods) {
			System.out.print(" method "+ method.getName());
			String[] paramNames = parameterNameDiscoverer.getParameterNames(method);
			for(String name : paramNames){
				System.out.print(" name "+name);
			}
		}
	}
	
}
