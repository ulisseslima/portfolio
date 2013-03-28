package com.dvlcube.servlet.interceptor;

import java.util.AbstractMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * http://stackoverflow.com/questions/3174373/is-there-a-shorthand-for-fmtmessage-key-key
 * 
 * This feels like a bit of a hack, but you could write a custom implementation of java.util.Map which, when
 * get(key) is called, fetches the message from the Spring MessageSource. This Map could be added to the model
 * under the msg key, allowing you to dereference the messages using ${msg.myKey}.
 * 
 * Perhaps there's some other dynamic structure than is recognized by JSP EL that isn't a Map, but DataStore can't
 * think of one offhand.
 */
public class I18nShorthandInterceptor extends HandlerInterceptorAdapter {

	private class DelegationMap extends AbstractMap<String, String> {
		private final Locale locale;

		public DelegationMap(final Locale locale) {
			this.locale = locale;
		}

		@Override
		public Set<Map.Entry<String, String>> entrySet() {
			// no need to implement this
			return null;
		}

		@Override
		public String get(final Object key) {
			try {
				return messageSource.getMessage((String) key, null, locale);
			} catch (final NoSuchMessageException ex) {
				return (String) key;
			}
		}

	}

	@Autowired
	private LocaleResolver localeResolver;

	@Autowired
	private MessageSource messageSource;

	@Override
	public boolean preHandle(
		final HttpServletRequest request,
		final HttpServletResponse response,
		final Object handler) throws Exception {

		request.setAttribute("msg", new DelegationMap(localeResolver.resolveLocale(request)));
		return true;
	}
}