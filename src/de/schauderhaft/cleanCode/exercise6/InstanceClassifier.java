package de.schauderhaft.cleanCode.exercise6;

import static java.util.Arrays.asList;

import java.util.Collection;

import de.schauderhaft.cleanCode.stubs.SrvParameterCache;

public class InstanceClassifier {

    private final Collection<String> testInstances = asList("grglmrpft",
            "sysmrpt", "gru23b12", "gru23b13");
    private final Collection<String> qaInstances = asList("grglmrpfqs",
            "gru23c12", "sysglmqs", "sysgmrpf-qs");

    boolean isTestInstance() {
        return matchesAny(sanatizedServerUrl(), testInstances);
    }

    boolean isQaInstance() {
        return matchesAny(sanatizedServerUrl(), qaInstances);
    }

    boolean isProductionInstance() {
        return !(isTestInstance() || isQaInstance());
    }

    private boolean matchesAny(String sanitizedUrl, Collection<String> instances) {
        for (String pattern : instances) {
            if (sanitizedUrl.contains(pattern))
                return true;
        }
        return false;
    }

    private String sanatizedServerUrl() {
        String url = SrvParameterCache
                .getParameterAsString(SrvParameterCache.WEB_URL_DEFAULT);
        if (url == null)
            url = "";

        return url.toLowerCase();
    }
}
