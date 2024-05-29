package jp.co.aforce.tool;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Action
 */
public abstract class Action {
	public abstract String execute(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception;

}
