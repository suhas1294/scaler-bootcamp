package _06_LLD._2022_11_25.solid.bird_design.concrete_classes;

import _06_LLD._2022_11_25.solid.bird_design.FlyingBehaviour;

public class PSFB implements FlyingBehaviour {
    @Override
    public void makeFly() {
        System.out.println("Flying parrot or sparrow !");
    }
}
