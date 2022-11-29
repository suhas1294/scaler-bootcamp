package _06_LLD._2022_11_25.solid.bird_design.concrete_classes;

import _06_LLD._2022_11_25.solid.bird_design.CrowOwlFlyingBehaviour;

public class COFB implements CrowOwlFlyingBehaviour {
    @Override
    public void makeFly() {
        System.out.println("Flying crow or owl !");
    }
}
