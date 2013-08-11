package de.schauderhaft.cleanCode.exercise5;

public class InstanceClassifier {

    boolean isTestInstance(String url) {
        return url.contains("grglmrpft") || url.contains("sysmrpt")
                || url.contains("gru23b12") || url.contains("gru23b13");
    }

    boolean isQaInstance(String url) {
        return url.contains("grglmrpfqs") || url.contains("gru23c12")
                || url.contains("sysglmqs") || url.contains("sysgmrpf-qs");
    }

    boolean isProductionInstance(String url) {
        return !(isTestInstance(url) || isQaInstance(url));
    }

}
