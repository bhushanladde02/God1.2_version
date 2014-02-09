package com.onine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.onine.god.GaaliDAO;
import com.onine.model.Gaali;

/**
 * Servlet implementation class History
 */
public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public History() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GaaliDAO gaaliDAO = new GaaliDAO();
		Gson gson = new GsonBuilder().create();
		
		String name=request.getParameter("name");
		
		if(name==null){
			String id=request.getParameter("id");
			List<Gaali> listGaali = gaaliDAO.getGaalis(id);
			
			
		/*	
			String gaaliListHtml = "";
			
			for (int i = 0; i < listGaali.size(); i++) {
				gaaliListHtml+="<li><a href=\"#detail\" id=\""+listGaali.get(i).getId()+"\"  onclick=\"loadDetails(this.id)\">"+listGaali.get(i).getGaali()+"</a></li>";
			}
			
			
			PrintWriter pw=response.getWriter();
			pw.write(gaaliListHtml);*/
			
			response.getWriter().print(gson.toJson(listGaali));
			
		}else if(name.equals("details")){
			
			String id=request.getParameter("gaali");
			Gaali gaali = gaaliDAO.getGaaliDetails(Integer.parseInt(id));
			/*
			
				String gaaliDescription ="<p><h1>"+gaali.getGaali()+"</h1></p>"+
						"<p><h4>"+gaali.getGaali().toLowerCase()+" ["+gaali.getPronounciation()+"]</h4></p>";
				
				if(!gaali.getDescription1().isEmpty())
					gaaliDescription+="<p><b>1. "+gaali.getDescription1()+" </b></p>";
				
				
				if(!gaali.getDescription2().isEmpty())
					gaaliDescription+="<p><b>2. "+gaali.getDescription2()+" </b></p>";
				
				if(!gaali.getDescription3().isEmpty())
					gaaliDescription+="<p><b>3. "+gaali.getDescription3()+" </b></p>";
				
				
				if(!gaali.getDescription4().isEmpty())
					gaaliDescription+="<p><b>4. "+gaali.getDescription4()+" </b></p>";
				
						
						gaaliDescription+="<p>"+gaali.getProperties()+"</p>"+
						"<p><b>Origin: </b>"+gaali.getOrigin()+"</p>"+
						"<p><b>Language support: </b>"+gaali.getLanguage()+"</p>"+
						"<p><b>Usage :</b></p>";
						
						
				if(!gaali.getUses1().isEmpty())
					gaaliDescription+="<p>&nbsp;&nbsp;&nbsp;1. "+gaali.getUses1()+" </p>";
				
				if(!gaali.getUses2().isEmpty())
					gaaliDescription+="<p>&nbsp;&nbsp;&nbsp;1. "+gaali.getUses2()+" </p>";
				
				if(!gaali.getUses3().isEmpty())
					gaaliDescription+="<p>&nbsp;&nbsp;&nbsp;1. "+gaali.getUses3()+" </p>";
				
				if(!gaali.getUses4().isEmpty())
					gaaliDescription+="<p>&nbsp;&nbsp;&nbsp;1. "+gaali.getUses4()+" </p>";
						
				
				gaaliDescription+="<p><b>Related to : </b>"+gaali.getRelatedTo()+"</p>";
				PrintWriter pw=response.getWriter();
				pw.write(gaaliDescription);*/
			
			response.getWriter().print(gson.toJson(gaali));
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/*public static void main(String[] args) {
		Gaali gaali = new GaaliDAO().getGaaliDetails(1);
		Gson gson = new GsonBuilder().create();
		Gaali gaaliBack = gson.fromJson(gson.toJson(gaali), Gaali.class);
		
		System.out.println(gaaliBack.getDescription1());
		
	}*/
}
