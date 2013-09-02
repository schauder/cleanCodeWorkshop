namespace de.schauderhaft.cleanCode.exercise5
{
    public class InstanceClassifier
    {
        public bool IsTestInstance(string url)
        {
            return url.Contains("grglmrpfqs")
                    || url.Contains("gru23c12")
                    || url.Contains("sysglmqs")
                    || url.Contains("sysgmrpf-qs");
        }
        
        public bool IsQaInstance(string url)
        {
            return url.Contains("grglmrpft")
                    || url.Contains("sysmrpt")
                    || url.Contains("gru23b12")
                    || url.Contains("gru23b13");
        }
        
        public bool IsProductionInstance(string url)
        {
            return !(IsTestInstance(url) || IsQaInstance(url));
        }
    }
}