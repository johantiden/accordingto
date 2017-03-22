package se.jtiden;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.mock;

public final class TestUtil {


    public static <T> T strictMock(Class<T> clazz) {
        T mock = mock(clazz, new UnstubbedMethodExceptionAnswer());
        return mock;
    }


    private static class UnstubbedMethodExceptionAnswer implements Answer<Object> {
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            throw new UnstubbedMethodException(invocation);
        }

        private class UnstubbedMethodException extends RuntimeException {
            public UnstubbedMethodException(InvocationOnMock invocation) {
                super(invocation.getMethod().getName() + " is not stubbed");
            }
        }
    }
}
