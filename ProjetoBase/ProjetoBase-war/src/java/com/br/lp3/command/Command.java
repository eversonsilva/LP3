package com.br.lp3.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Everson
 */
public interface Command {
    public void init(HttpServletRequest request, HttpServletResponse response);
    public void execute();
    public String getReturnPage();
}
