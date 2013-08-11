package de.schauderhaft.cleanCode.exercise6;

import de.schauderhaft.cleanCode.stubs.Translator;

public class TextStrategy {
    InstanceClassifier classifier = new InstanceClassifier();

    String getText() {
        if (classifier.isTestInstance())
            return Translator.translate("lblStageInfoTest");
        else if (classifier.isQaInstance())
            return Translator.translate("lblStageInfoQs");
        else
            return Translator.translate("lblStageInfoPrd");

    }
}
