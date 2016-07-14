package by.it.luksha.project.java;

import javax.servlet.http.HttpServletRequest;

interface ActionCommand {
    String execute(HttpServletRequest request);
}