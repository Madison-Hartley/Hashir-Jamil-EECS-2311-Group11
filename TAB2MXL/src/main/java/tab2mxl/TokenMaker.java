package tab2mxl;

import java.util.LinkedList;
import java.util.regex.Pattern;



public class TokenMaker {

	
	private class TokenInfo {
		public final Pattern regex;
		public final int token;
		
		public TokenInfo(Pattern regex, int token) {
			super();
			this.regex = regex;
			this.token = token;
		}
	}
	
	private LinkedList<TokenInfo> tokenInfos;
	private LinkedList<Token> tokens;
	
	public TokenMaker() {
		tokenInfos = new LinkedList<TokenInfo>();
		tokens = new LinkedList<Token>();
	}
	
	
	public void add(String regex, int token) {
		tokenInfos.add(new TokenInfo(Pattern.compile("^("+regex+")"), token));
	}
	
	public void tokenize(String str) {
		String s = new String(str);
		tokens.clear();
		
		while (!s.equals(" ")) {
			
		}
		
	}
	
	
	
}