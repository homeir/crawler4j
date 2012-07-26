package edu.uci.ics.crawler4j.login;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class LoginConfiguration {
	private String host;
	private URL loginForm;
	private URL post;
	private List<NameValuePair> params = new ArrayList<NameValuePair>();

	public LoginConfiguration(String host, URL loginForm, URL post) {
		this.host = host;
		this.loginForm = loginForm;
		this.post = post;
	}

	public void addParam(String name, String value) {
		params.add(new BasicNameValuePair(name, value));
	}

	public boolean isSupport(URL url) {
		return url.getHost().equals(host);
	}

	public URL getPost() {
		return post;
	}

	public List<NameValuePair> getParams() {
		return params;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginForm == null) ? 0 : loginForm.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginConfiguration other = (LoginConfiguration) obj;
		if (loginForm == null) {
			if (other.loginForm != null)
				return false;
		} else if (!loginForm.equals(other.loginForm))
			return false;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		return true;
	}

}
