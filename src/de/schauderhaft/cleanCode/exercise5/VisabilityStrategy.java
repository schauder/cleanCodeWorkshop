package de.schauderhaft.cleanCode.exercise5;

import de.schauderhaft.cleanCode.stubs.SrvParameterCache;
import de.schauderhaft.cleanCode.stubs.StringStatic;

public class VisabilityStrategy {
    InstanceClassifier classifier = new InstanceClassifier();

    boolean getVisibility(LabelGenerator labelGenerator) {
        boolean visibility = true;
        try {
            String importUrl = SrvParameterCache
                    .getParameterAsString(SrvParameterCache.WEB_URL_DEFAULT);
            if (!StringStatic.isEmptyOrNullValue(importUrl)) {
                importUrl = importUrl.toLowerCase();
                if (classifier.isProductionInstance(importUrl)) {
                    visibility = false;
                }
            }
        } catch (Exception e) {
            visibility = false;
        }
        return visibility;
    }

}
