package simplifyPath;

import java.util.Stack;

public class Solution {
	public String simplifyPath(String path) {
        Stack<String> paths = new Stack<String>();
        for (String p: path.split("/")) {
            if (p.equals(".")||p.equals("")) continue;
            else if (p.equals("..")) {
            	if (!paths.empty())
            		paths.pop();
            }
            else paths.push(p);
        }
        if (paths.empty()) return "/";
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < paths.size(); i++) {
            b.append("/");
            b.append(paths.get(i));
        }
        return b.toString();
    }
    
    public static void main(String[]a) {
    	Solution s = new Solution();
    	System.out.println(s.simplifyPath("/.."));
    	System.out.println(s.simplifyPath("/a/b/c"));
    	System.out.println(s.simplifyPath("///a///b/c"));
    	System.out.println(s.simplifyPath("/a/././././b/c/../a/b/"));
    }
}