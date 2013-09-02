using System;
using System.Windows.Forms;
using de.schauderhaft.cleanCode.stubs;

namespace de.schauderhaft.cleanCode.exercise0
{
    public class LabelGenerator 
    {
        private Label lblStageInfo;
        
        public Label GetLblStageInfo() 
        {
            if (lblStageInfo == null)
            {
                lblStageInfo = new Label();
                
                string text = _("lblStageInfoPrd");
                try
                {
                    string importUrl = SrvParameterCache
                        .GetParameterAsString(SrvParameterCache.WEB_URL_DEFAULT);
                    if (!StringStatic.IsEmptyOrNullValue(importUrl))
                    {
                        importUrl = importUrl.ToLower();
                        
                        //Test-Instanz
                        if (importUrl.Contains("grglmrpft")
                            || importUrl.Contains("sysmrpt")
                            || importUrl.Contains("gru23b12")
                            || importUrl.Contains("gru23b13")) 
                        {
                            // Test
                            text = _("lblStageInfoTest");
                        }
                        // QS-Instanz
                        else if (importUrl.Contains("grglmrpfqs")
                            || importUrl.Contains("gru23c12")
                            || importUrl.Contains("sysglmqs")
                            || importUrl.Contains("sysgmrpf-qs")) 
                        {
                            // QS
                            text = _("lblStageInfoQs");
                        }
                        // PRD-Instanz (oder neue, bzw. noch nicht bekannte
                        // Instanz)
                        else 
                        {
                            // Produktiv nur anzeigen, wenn es nicht die
                            // PRD-Instanz ist
                            lblStageInfo.Visible = false;
                        }
                    }
                }
                catch (Exception e)
                {
                    lblStageInfo.Visible = false;
                    Console.WriteLine(e.Message);
                    Console.WriteLine(e.StackTrace);
                }
                
                lblStageInfo.Text = text;
            }
            return lblStageInfo;
        }
        
        private string _(string message)
        {
            return Translator.Translate(message);
        }
    }
}