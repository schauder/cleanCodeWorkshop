using de.schauderhaft.cleanCode.stubs;

namespace de.schauderhaft.cleanCode.exercise6
{
    public class TextStrategy
    {
        private InstanceClassifier classifier = new InstanceClassifier();
        
        public string GetText()
        {
            if (classifier.IsTestInstance()) 
            {
                return Translator.Translate("lblStageInfoTest");
            }
            else if (classifier.IsQaInstance()) 
            {
                return Translator.Translate("lblStageInfoQs");
            }
            else
            {
                return Translator.Translate("lblStageInfoPrd");
            }
        }
    }
}