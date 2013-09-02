using de.schauderhaft.cleanCode.stubs;

namespace de.schauderhaft.cleanCode.exercise5
{
    public class VisibilityStrategy
    {
        private InstanceClassifier classifier = new InstanceClassifier();
        
        public bool GetVisibility()
        {
            bool visibility = true;
            
            string importUrl = SrvParameterCache
                .GetParameterAsString(SrvParameterCache.WEB_URL_DEFAULT);
            if (!StringStatic.IsEmptyOrNullValue(importUrl)) 
            {
                importUrl = importUrl.ToLower();
                if (classifier.IsProductionInstance(importUrl)) 
                {
                    visibility = false;
                }
            }
            return visibility;
        }
    }
}