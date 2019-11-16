package ch.g_7.terror.dao.util;

@FunctionalInterface
public interface ExecutionUnit<I,O> {

	public O execute(I input);
}
