package by.it.vasilevich.jd01_08;


public class Header extends Engineer{
    @Override
    public String showState() {
        String state = "Руководитель не на работе";
        if(this.isStategoToWork()) {
            state = "Руководитель пришел на работу";
            if (this.isStatework()) {
                state = "Выполняет работу";
                if (this.isStategoLunch()){
                    state = "Ушел на обед";
                    if(this.isStateoutLunch()){
                        state = "Вернулся с обеда";
                        if(this.isStategoOutWork()){
                            state = "Ушел с работы";
                        }
                    }
                }
            }
        }
        return state;
    }
}
