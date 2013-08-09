package de.schauderhaft.cleanCode.exercise1;

import javax.swing.JLabel;

import de.schauderhaft.cleanCode.stubs.SrvParameterCache;
import de.schauderhaft.cleanCode.stubs.StringStatic;
import de.schauderhaft.cleanCode.stubs.Translator;

public class LabelGenerator {

    JLabel lblStageInfo;

    public JLabel getLblStageInfo() {
        if (lblStageInfo == null) {
            lblStageInfo = new JLabel();

            String text = _("lblStageInfoPrd");

            try {
                String importUrl = SrvParameterCache
                        .getParameterAsString(SrvParameterCache.WEB_URL_DEFAULT);
                if (!StringStatic.isEmptyOrNullValue(importUrl)) {
                    importUrl = importUrl.toLowerCase();

                    // Test-Instanz
                    if (importUrl.contains("grglmrpft")
                            || importUrl.contains("sysmrpt")
                            || importUrl.contains("gru23b12")
                            || importUrl.contains("gru23b13")) {
                        // Test
                        text = _("lblStageInfoTest");
                    }
                    // QS-Instanz
                    else if (importUrl.contains("grglmrpfqs")
                            || importUrl.contains("gru23c12")
                            || importUrl.contains("sysglmqs")
                            || importUrl.contains("sysgmrpf-qs")) {
                        // QS
                        text = _("lblStageInfoQs");
                    }
                    // PRD-Instanz (oder neue, bzw. noch nicht bekannte
                    // Instanz)
                    else {
                        // Produktiv nur anzeigen, wenn es nicht die
                        // PRD-Instanz ist
                        lblStageInfo.setVisible(false);
                    }
                }
            } catch (Exception e) {
                lblStageInfo.setVisible(false);
                e.printStackTrace();
            }

            lblStageInfo.setText(text);
        }

        return lblStageInfo;
    }

    private String _(String string) {

        return Translator.translate(string);
    }
}
