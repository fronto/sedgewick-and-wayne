package com.thomas.preparation.vector.test;

public interface VectorCallbackResult<T> {

	VectorClient<T> processResult(T result, VectorClient<T> vectorClient);

}
