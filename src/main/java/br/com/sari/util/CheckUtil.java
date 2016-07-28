package br.com.sari.util;

import java.util.Collection;

public class CheckUtil {
	public static <T> boolean isNullOrEmpty(final Collection<T> list) {
		return list == null || list.isEmpty();
	}

	public static boolean isNull(final Object object) {
		if (object == null) {
			return true;
		}
		return false;

	}

}
