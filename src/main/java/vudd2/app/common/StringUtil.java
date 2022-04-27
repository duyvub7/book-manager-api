package vudd2.app.common;

import java.text.Normalizer;

public class StringUtil {
	
	public static String FixString(String s) {
		s = Normalizer.normalize(s, Normalizer.Form.NFD);
	    s = s.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	    return s;
	}
}
