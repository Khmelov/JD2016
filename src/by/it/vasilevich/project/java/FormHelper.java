package by.it.vasilevich.project.java;

import by.it.akhmelev.project.java.Action;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

class FormHelper {
    //этот класс для чтения и валидации данных в форме
    private HttpServletRequest request;

    //Не статический вариант удобнее. Создается из запроса.
    public FormHelper(HttpServletRequest request) {
        this.request = request; //запомним ссылку на запрос.
    }

    //валидация данных из формы с заданным шаблоном
    private boolean valid(String value, String pattern) {
        //проверка на внимательность (для определения, вы просто копируете код или читаете)
        //тут явно не все, нужно проврить не просто вхождение паттерна в строку
        //а полное соответствие всей строки шаблону. Доделайте.
        return (value != null) && value.matches(pattern);
    }

    public Integer getInt(String nameFieldForm) throws Exception {
        String value = request.getParameter(nameFieldForm);
        boolean res = (value != null && valid(value, "[.,0-9-]+"));
        if (res) {
            return Integer.parseInt(value);
        } else
            throw new Exception("Not valid data");
    }

    public Double getDouble(String nameFieldForm) throws Exception {
        String value = request.getParameter(nameFieldForm);
        boolean res = (value != null && valid(value, "[.,0-9-]+"));
        if (res) {
            return Double.parseDouble(value);
        } else
            throw new Exception("Not valid data");
    }

    public String getString(String nameFieldForm) throws Exception {
        String value = request.getParameter(nameFieldForm);
        boolean res = (value != null && valid(value, ".*"));
        if (res) {
            return value;
        } else
            throw new Exception("Not valid data");
    }

    public boolean isPost(){
        return request.getMethod().equalsIgnoreCase("post");
    }

    public void setMessage(String message){
        request.setAttribute(by.it.akhmelev.project.java.Action.msgMessage, message);
    }

    public void setErrorMessage(String message){
        request.setAttribute(Action.msgError, message);
    }

    //это экземплярный метод для отладки. Он покажет в виде текста, что пришло из формы
    //пока приватный, но вполне может быть и публичным
    public String strDebugForm() {
        String formText = "";
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String field = parameterNames.nextElement();
            String value = request.getParameter(field);
            formText = formText.concat(field + "=" + value + "; ");
        }
        return formText;
    }

    //это статический метод для отладки. Он покажет в виде текста, что пришло из формы
    static String strDebugForm(HttpServletRequest request) {
        return new FormHelper(request).strDebugForm();
    }


}
