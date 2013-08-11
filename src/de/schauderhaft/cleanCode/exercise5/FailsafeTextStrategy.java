package de.schauderhaft.cleanCode.exercise5;

import de.schauderhaft.cleanCode.stubs.Translator;

public class FailsafeTextStrategy {
    TextStrategy delegate = new TextStrategy();

    String getText() {
        try {
            return delegate.getText();
        } catch (Exception e) {
            return Translator.translate("lblStageInfoPrd");
        }
    }
}
