package de.schauderhaft.cleanCode.exercise6;

public class VisabilityStrategy {
    InstanceClassifier classifier = new InstanceClassifier();

    boolean getVisibility() {
        return !classifier.isProductionInstance();
    }
}
