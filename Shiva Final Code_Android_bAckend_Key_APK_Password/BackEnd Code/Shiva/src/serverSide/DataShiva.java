package serverSide;

public class DataShiva {
  public String headerValue;
  public String newsDetails;
  public String id;
  public String authValue;
  public String lastUpdatedDt;
  public String person;
public String getPerson() {
	return person;
}
public void setPerson(String person) {
	this.person = person;
}
public String getLastUpdatedDt() {
	return lastUpdatedDt;
}
public void setLastUpdatedDt(String lastUpdatedDt) {
	this.lastUpdatedDt = lastUpdatedDt;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getAuthValue() {
	return authValue;
}
public void setAuthValue(String authValue) {
	this.authValue = authValue;
}
public String getHeaderValue() {
	return headerValue;
}
public void setHeaderValue(String headerValue) {
	this.headerValue = headerValue;
}
public String getNewsDetails() {
	return newsDetails;
}
public void setNewsDetails(String newsDetails) {
	this.newsDetails = newsDetails;
}


public String authString() {
	if(authValue.equalsIgnoreCase("y")){
		return "<tr><td>बातम्या  क्रमांक : "+id+"<br/><b>"+headerValue+":</b><br/>"+newsDetails+"<br/><b> तारीख:</b>"+lastUpdatedDt.split("/")[2]+"/"+lastUpdatedDt.split("/")[1]+"/"+lastUpdatedDt.split("/")[0]+" <br><button id='button"+id+"' onclick=\"authvalue('"+id+"','y')\"> <font color=\"red\">* अधिकृत (Authorize) * </font></button> <button  id='button"+id+"' onclick=\"authvalue('"+id+"','n')\">अधिकृत नाही (Not Authorize) </button></br></td></tr>";
	}else{
		return "<tr><td>बातम्या  क्रमांक : "+id+"<br/><b>"+headerValue+":</b><br/>"+newsDetails+"<br/><b> तारीख:</b>"+lastUpdatedDt.split("/")[2]+"/"+lastUpdatedDt.split("/")[1]+"/"+lastUpdatedDt.split("/")[0]+" <br><button  id='button"+id+"' onclick=\"authvalue('"+id+"','y')\">अधिकृत  (Not Authorize)</button> <button  id='button"+id+"' onclick=\"authvalue('"+id+"','n')\"><font color=\"red\">* अधिकृत नाही (Not Authorize) *</font></button></br></td></tr>";
	}
}
@Override
	public String toString() {
		
		return "<tr><td><b>"+headerValue+":</b><br/>"+newsDetails+"<br/><b> तारीख:</b>"+lastUpdatedDt.split("/")[2]+"/"+lastUpdatedDt.split("/")[1]+"/"+lastUpdatedDt.split("/")[0]+"</td></tr>";
	}
  
}
