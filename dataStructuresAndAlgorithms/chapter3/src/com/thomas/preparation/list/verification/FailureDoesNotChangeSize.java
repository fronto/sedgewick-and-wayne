package com.thomas.preparation.list.verification;

import com.thomas.preparation.list.List;

public class FailureDoesNotChangeSize extends WithExceptionHandling {

	private int sizeBefore;

	public FailureDoesNotChangeSize() {
	}

	@Override
	void beforeInvocation(List<?> invokee) {
		sizeBefore = invokee.size();
	}

	@Override
	void onFailure(List<?> invokee) {
		int sizeAfter = invokee.size();
		assert sizeAfter == sizeBefore;
	}
}
