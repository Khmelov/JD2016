package by.it.sergeev.project.java;

import javax.servlet.http.HttpServletRequest;
interface ActionCommand {
    String execute(HttpServletRequest request);
}