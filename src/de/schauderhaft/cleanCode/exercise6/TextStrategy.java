package de.schauderhaft.cleanCode.exercise6;

import de.schauderhaft.cleanCode.stubs.SrvParameterCache;
import de.schauderhaft.cleanCode.stubs.StringStatic;
import de.schauderhaft.cleanCode.stubs.Translator;

public class TextStrategy {
    InstanceClassifier classifier = new InstanceClassifier();

    String getText() {

        String text = Translator.translate("lblStageInfoPrd");

        String importUrl = SrvParameterCache
                .getParameterAsString(SrvParameterCache.WEB_URL_DEFAULT);
        if (!StringStatic.isEmptyOrNullValue(importUrl)) {
            importUrl = importUrl.toLowerCase();

            if (classifier.isTestInstance(importUrl)) {
                text = Translator.translate("lblStageInfoTest");
            } else if (classifier.isQaInstance(importUrl)) {
                text = Translator.translate("lblStageInfoQs");
            }
        }

        return text;
    }
}
