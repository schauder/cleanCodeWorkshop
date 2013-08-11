package de.schauderhaft.cleanCode.exercise6;

import de.schauderhaft.cleanCode.stubs.SrvParameterCache;
import de.schauderhaft.cleanCode.stubs.StringStatic;

public class VisabilityStrategy {
    InstanceClassifier classifier = new InstanceClassifier();

    boolean getVisibility() {
        boolean visibility = true;

        String importUrl = SrvParameterCache
                .getParameterAsString(SrvParameterCache.WEB_URL_DEFAULT);
        if (!StringStatic.isEmptyOrNullValue(importUrl)) {
            importUrl = importUrl.toLowerCase();
            if (classifier.isProductionInstance(importUrl)) {
                visibility = false;
            }
        }

        return visibility;
    }

}
