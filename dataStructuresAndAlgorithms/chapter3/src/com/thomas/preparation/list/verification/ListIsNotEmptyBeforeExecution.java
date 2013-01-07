package com.thomas.preparation.list.verification;

import com.thomas.preparation.list.List;

public class ListIsNotEmptyBeforeExecution extends WithExceptionHandling {

	@Override
	void beforeInvocation(List<?> invokee) {
		assert invokee.size() > 0 && !invokee.isEmpty();
	}
	
}
