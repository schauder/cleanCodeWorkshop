using de.schauderhaft.cleanCode.stubs;

namespace de.schauderhaft.cleanCode.exercise5
{
    public class TextStrategy
    {
        private InstanceClassifier classifier = new InstanceClassifier();
        
        public string GetText()
        {
            string text = Translator.Translate("lblStageInfoPrd");
            string importUrl = SrvParameterCache
                    .GetParameterAsString(SrvParameterCache.WEB_URL_DEFAULT);
            if (!StringStatic.IsEmptyOrNullValue(importUrl))
            {
                importUrl = importUrl.ToLower();
                
                if (classifier.IsTestInstance(importUrl)) 
                {
                    text = Translator.Translate("lblStageInfoTest");
                }
                else if (classifier.IsQaInstance(importUrl)) 
                {
                    text = Translator.Translate("lblStageInfoQs");
                }
            }
            
            return text;
        }
    }
}