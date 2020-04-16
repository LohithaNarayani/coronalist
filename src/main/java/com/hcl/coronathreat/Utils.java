package com.hcl.coronathreat;

import java.util.Iterator;
import java.util.List;

public class Utils {
    static String startTemplate="<html>\r\n" + 
    		"  <head>\r\n" + 
    		"    <title>CoronaList</title>\r\n" + 
    		"    <h1 align=\"center\">Covid19 List</h1>\r\n" + 
    		"  </head>\r\n" + 
    		"  <body>\r\n" + 
    		"   \r\n" + 
    		"<table border=\"5\" cellpadding = \"5\" cellspacing = \"5\" align=\"center\">\r\n" + 
    		"<tr bgcolor = \"lime\">\r\n" + 
    		"<td>State</td>\r\n" + 
    		"<td>Distirct</td>\r\n" + 
    		"<td>MaleCount</td>\r\n" + 
    		"<td>FemaleCount</td>\r\n" + 
    		"</tr>";
    static String endTemplate="</table>\r\n" + 
    		"  </body>\r\n" + 
    		"</html>";
	public static String getHtmlData(List<CoronalistEntity> entity) {
		 int maleCount=0;
		 int femaleCount=0;
		StringBuilder sb=new StringBuilder();
		sb.append(startTemplate);
		for (Iterator iterator = entity.iterator(); iterator.hasNext();) {
			CoronalistEntity coronalistEntity = (CoronalistEntity) iterator.next();
			String trData=getRow(coronalistEntity.getState(), coronalistEntity.getCity(), coronalistEntity.getMale(), coronalistEntity.getFemale());
		    sb.append(trData);
		     maleCount=maleCount+Integer.valueOf(coronalistEntity.getMale());
			 femaleCount=femaleCount+Integer.valueOf(coronalistEntity.getFemale());		 
		}
		String trTotal="<tr>\r\n" + 
				"<td colspan=2 align=\"center\" bgcolor=\"yellow\">Total</td>\r\n" + 
				"<td>"+maleCount+"</td>\r\n" + 
				"<td>"+femaleCount+"</td>\r\n" + 
				"</tr>";
		return sb.append(trTotal).append(endTemplate).toString();
	}
	
	public static String getRow(String state,String city,String maleCount,String femaleCount) {
		String template="<tr>\r\n" + 
				"<td>"+state+"</td>\r\n" + 
				"<td>"+city+"</td>\r\n" + 
				"<td>"+maleCount+"</td>\r\n" + 
				"<td>"+femaleCount+"</td>\r\n" + 
				"</tr>";
		return template;
	}
}
