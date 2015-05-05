package serverSide;

public class DataShiva {
  public String headerValue;
  public String newsDetails;
  public String id;
  public String authValue;
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
@Override
	public String toString() {
		
		return "<tr><td><b>"+headerValue+":</b><br/>"+newsDetails+"</td></tr>";
	}
  
}
