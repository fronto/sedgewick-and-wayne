package com.thomas.preparation.list.verification;

import java.lang.reflect.Method;

public interface MethodInvocationCommand<T> {
	
	Object executeMethodInvocation(T invokee, Method theMethod, Object[] args) throws Exception;
	
}
