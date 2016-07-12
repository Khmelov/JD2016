package by.it.sinkevich.project.java;


public enum Action {

    REGISTER {
        {
            command = new CommandRegister();
            startPage = "/signup.jsp";
            okPage = "/login.jsp";
        }
    },
    LOGIN {
        {
            command = new CommandLogin();
            startPage = "/login.jsp";
            okPage = "/main.jsp";
        }
    },
    LOGOUT {
        {
            command = new CommandLogout();
            startPage = "/login.jsp";
            okPage = "/login.jsp";
        }
    },
    ERROR {
        {
            command = new CommandError();
            startPage = "/error.jsp";
            okPage = "/error.jsp";
        }
    },
    PLACE_BET {
        {
            command = new CommandPlaceBet();
            startPage = "/main.jsp";
            okPage = "/main.jsp";
        }
    },
    VIEW_RACES {
        {
            command = new CommandViewRaces();
            startPage = "/main.jsp";
            okPage = "/main.jsp";
        }
    };

    public String startPage;
    public String okPage;
    public ActionCommand command;
}
