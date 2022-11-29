package _06_LLD._2022_11_25.solid.bird_design.concrete_classes;

import _06_LLD._2022_11_25.solid.bird_design.Flyable;
import _06_LLD._2022_11_25.solid.bird_design.FlyingBehaviour;

public class Parrot implements Flyable {
    FlyingBehaviour flyingBehaviour;

    @Override
    public void fly() {
        flyingBehaviour = new PSFB();
        flyingBehaviour.makeFly();
    }
}
