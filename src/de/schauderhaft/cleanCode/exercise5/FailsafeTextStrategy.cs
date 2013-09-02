using System;
using de.schauderhaft.cleanCode.stubs;

namespace de.schauderhaft.cleanCode.exercise5
{
    public class FailsafeTextStrategy
    {
        private TextStrategy strategy = new TextStrategy(); 
        
        public string GetText()
        {
            try
            {
                return strategy.GetText();
            }
            catch
            {
                return Translator.Translate("lblStageInfoPrd");
            }
        }
    }
}