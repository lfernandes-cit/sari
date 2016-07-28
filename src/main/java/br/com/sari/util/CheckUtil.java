package br.com.sari.util;

import java.util.Collection;

public class CheckUtil {
	public static <T> boolean IsNullOrEmpty(final Collection<T> list) {
		return list == null || list.isEmpty();
	}

	public static boolean IsNull(final Object object) {
		if (object == null) {
			return true;
		}
		return false;

	}

}
