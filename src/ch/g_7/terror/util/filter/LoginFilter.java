package ch.g_7.terror.util.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.g_7.terror.bean.HelperBean;
import ch.g_7.terror.util.message.Message;
import ch.g_7.terror.util.message.MessageArray;
import ch.g_7.terror.util.message.MessageStyle;

public class LoginFilter implements Filter {

	@Inject
	private HelperBean helperBean;

	@Inject
	private MessageArray msgArray;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String contextPath = ((HttpServletRequest) request).getContextPath();

		if (!helperBean.isLogedIn()) {
			msgArray.addMessage(new Message(MessageStyle.error, "Access denied!"));
			((HttpServletResponse) response).sendRedirect(contextPath + "/signin.xhtml");
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
