package com.thomas.preparation.list.verification;

import com.thomas.preparation.list.List;

public class SizeIncreasesOnSuccess extends FailureDoesNotChangeSize {

	private int sizeBefore;

	@Override
	void beforeInvocation(List<?> invokee) {
		sizeBefore = invokee.size();
	}

	@Override
	void onSuccess(List<?> invokee) {
		int sizeAfter = invokee.size();
		assert sizeAfter == sizeBefore + 1;
	}

}
