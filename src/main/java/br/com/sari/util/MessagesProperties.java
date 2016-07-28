package br.com.sari.util;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.Properties;

import org.slf4j.LoggerFactory;


public class MessagesProperties {

	/**
	 * Log.
	 */
	static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MessagesProperties.class);

	/**
	 * properties.
	 */
	private static Properties PROPERTIES = null;


	static {
		readBundle();
	}

	/**
	 *
	 * Retorna o valor do properties passando o key.
	 *
	 * @param key
	 *            as String
	 * @return String
	 */
	public static String getMessage(final String key) {
		return PROPERTIES.getProperty(key);
	}

	/**
	 * Get Message.
	 * @param key k
	 * @param params p
	 * @return s
	 */
	public static String getMessage(final String key, final Object... params) {
		try {
			return MessageFormat.format(getMessage(key), params);
		} catch (final MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * Leitura do properties.
	 */
	private static void readBundle() {
		if (PROPERTIES == null) {
			PROPERTIES = new Properties();
		}

		try {
			PROPERTIES.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("messages.properties"));

		} catch (final FileNotFoundException e) {
			LOG.error(e.getMessage(), e);
		} catch (final IOException e) {
			LOG.error(e.getMessage(), e);
		}
	}

}
