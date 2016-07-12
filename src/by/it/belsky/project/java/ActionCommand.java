package by.it.belsky.project.java;

import javax.servlet.http.HttpServletRequest;

interface ActionCommand {
    String execute(HttpServletRequest request);
}