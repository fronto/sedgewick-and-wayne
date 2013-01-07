package com.thomas.preparation.list.verification;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.thomas.preparation.list.List;

public class WithExceptionHandling implements MethodInvocationCommand<List<?>> {

	public WithExceptionHandling() {
	}
	
	@Override
	public Object executeMethodInvocation(List<?> invokee, Method theMethod, Object[] args) throws Exception {
		boolean success = false;
		beforeInvocation(invokee);
		try {
			Object result = theMethod.invoke(invokee, args);
			success = true;
			return result;
		} catch (InvocationTargetException e) {
			success = false;
			onFailure(invokee);
			throw e;
		} finally {
			if (success) {
				onSuccess(invokee);
			}
			irrespectiveOfOutcome(invokee);
		}

	}

	void beforeInvocation(List<?> invokee) {
		
	}

	void irrespectiveOfOutcome(List<?> invokee) {
		
	}

	void onFailure(List<?> invokee) {
		
	}

	void onSuccess(List<?> invokee) {

	}


}
