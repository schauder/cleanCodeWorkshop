package de.schauderhaft.cleanCode.exercise5;

public class FailsafeVisabilityStrategy {
    VisabilityStrategy delegate = new VisabilityStrategy();

    boolean getVisibility(LabelGenerator labelGenerator) {
        try {
            return delegate.getVisibility();
        } catch (Exception e) {
            return false;
        }
    }

}
