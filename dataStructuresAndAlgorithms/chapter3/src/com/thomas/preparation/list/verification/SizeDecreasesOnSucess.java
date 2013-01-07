package com.thomas.preparation.list.verification;

import com.thomas.preparation.list.List;

public class SizeDecreasesOnSucess extends FailureDoesNotChangeSize {

	private int sizeBefore;
	private int sizeAfter;

	public SizeDecreasesOnSucess() {
		
	}

	@Override
	void beforeInvocation(List<?> invokee) {
		sizeBefore = invokee.size();
	}

	@Override
	void onSuccess(List<?> invokee) {
		sizeAfter = invokee.size();
		assert sizeAfter == sizeBefore -1;
	}
	

}
