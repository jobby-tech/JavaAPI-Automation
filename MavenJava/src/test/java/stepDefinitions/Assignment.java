package stepDefinitions;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class Assignment {

	

	@Given("^start the script$")

	public void start_the_script(){

		System.out.println("script execution started");

	}

	

	@Then("^script execution in progress$")

	public void script_execution_in_progress ()throws ClientProtocolException, IOException{

		System.out.println("script execution in progress");
		
		
		HttpClient client = HttpClientBuilder.create().build();    
	    HttpResponse response = client.execute(new HttpGet("https://simple-books-api.glitch.me/books?limit=1&type=fiction"));
	    
	    int statusCode = response.getStatusLine().getStatusCode();
	    	   
	    System.out.println(EntityUtils.toString(response.getEntity()));
	    System.out.println(statusCode);
	    

	}

	

	@And("^Execution completed$")

	 public void Executioncompleted(){

		System.out.println("Execution completed");
		
		

	}
	
	
	
	@And("^Get API Response$")   
	
	public void Get_API_Response() throws IOException   
	
	{
		//With Error Handling
		
		CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

            HttpGet request = new HttpGet("https://simple-books-api.glitch.me/books?limit=1&type=fiction");

            
            CloseableHttpResponse response = httpClient.execute(request);

            try {

                // Get HttpResponse Status
                            
                System.out.println(response.getStatusLine().getStatusCode());                  
                

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String result = EntityUtils.toString(entity);
                    System.out.println(result);
                }

            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
	}


@And("^Try Simple Post$")	
	public void Try_Simple_Post() throws IOException{
		
		 
				String url="https://simple-books-api.glitch.me/api-clients";
		        String result = "";
		        HttpPost post = new HttpPost(url);
		        //post.addHeader("Authorization", "Bearer 4b899e341b3a29bb5c9c9cd11c08cad179a84b07b71fe76f9f754d43a64a3c23");
		        
		        post.setHeader("Accept", "application/json");
			    post.setHeader("Content-type", "application/json");
			    
//		        StringBuilder json = new StringBuilder();
//		        json.append("{");
//		        json.append("\"clientName\":\"mkyong\",");
//		        json.append("\"clientEmail\":\"hellsdo@g.com\"");
//		        json.append("}");
			    
			    String json = "{\r\n"+	        
			    		"\"clientName\": \"mkyong\",\r\n"+
			    		"\"clientEmail\": \"hellsdo@g.com\"\r\n"+
			    		"}\r\n"+
			    		"";

		        System.out.println(json);
		        // send a JSON data
		        post.setEntity(new StringEntity(json.toString()));

		        
		        try (CloseableHttpClient httpClient = HttpClients.createDefault();
		        		
		             CloseableHttpResponse response = httpClient.execute(post)) {

		            result = EntityUtils.toString(response.getEntity());
		            System.out.println(result);
		        }

		        		    
		
		
	}
		
}
