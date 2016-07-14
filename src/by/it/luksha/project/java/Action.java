package by.it.luksha.project.java;


enum Action {
    //регистрация
    SIGNUP {
        {
            this.command = new CommandSignUp();
            this.inPage="/signup.jsp";
            this.okPage ="/signin.jsp";
        }
    },
    //авторизация
    SIGNIN {
        {
            this.command = new CommandSignIn();
            this.inPage="/signin.jsp";
            this.okPage ="/index.jsp";
        }
    },
    //
    LOGOUT {
        {
            this.command = new CommandLogout();
            this.inPage="/signin.jsp";
            this.okPage ="/signin.jsp";
        }
    },
    //
    ERROR {
        {
            this.command = new CommandLogout();
        }
    };
    public String inPage="/error.jsp";
    public String okPage ="/error.jsp";
    public ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

    public static final String msgError="msg_error";
    public static final String msgMessage="message";

}