using System;

namespace de.schauderhaft.cleanCode.stubs
{
    public class StringStatic 
    {
        public static bool IsEmptyOrNullValue(string s)
        {
            return string.IsNullOrEmpty(s);
        }
    }
}