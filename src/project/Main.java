package project;


import project.util.ChooseTask;
import project.util.exception.ExitException;


public class Main {


    public static void main(String[] args) throws ExitException {

        ChooseTask chooseTask = new ChooseTask();
        chooseTask.chooser();

    }
}