package by.it.vasilevich.jd01_08;


public abstract class Engineer implements IWorker{
    //возможные состояния объекта
    private boolean stategoToWork = false;
    private boolean statework = false;
    private boolean stategoLunch = false;
    private boolean stateoutLunch = false;
    private boolean stategoOutWork = false;


    @Override
    public boolean goToWork() {
        stategoToWork = true;
        statework = false;
        return stategoToWork;
    }

    @Override
    public boolean work() {
        stategoToWork = true;
        statework = true;
        stategoLunch = false;
        return false;
    }

    @Override
    public boolean goLunch() {
        stategoToWork = true;
        statework = true;
        stategoLunch = true;
        stateoutLunch = false;
        return false;
    }

    @Override
    public boolean outLunch() {
        stategoToWork = true;
        statework = true;
        stategoLunch = true;
        stateoutLunch = true;
        stategoOutWork = false;
        return stateoutLunch;
    }

    @Override
    public boolean goOutWork() {
        stategoToWork = true;
        statework = true;
        stategoLunch = true;
        stateoutLunch = true;
        stategoOutWork = true;
        return stategoOutWork;
    }


    public abstract String showState();

    public boolean isStategoToWork(){return stategoToWork;}
    public boolean isStatework(){return statework;}
    public boolean isStategoLunch(){return stategoLunch;}
    public boolean isStateoutLunch(){return stateoutLunch;}
    public boolean isStategoOutWork(){return stategoOutWork;}


}
