package com.onine.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;
import com.onine.god.RegisterDevice;
import com.onine.logger.Log;

/**
 * Servlet implementation class GODGaliBroadCast
 */
public class GODGaliBroadCast extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger logger = new Log().getLogger(GODGaliBroadCast.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GODGaliBroadCast() {
        super();
        // TODO Auto-generated constructor stub
        logger.info("Servlet Initialized");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String regId = request.getParameter("regId");
		logger.info("Get Request recevied "+request.getContentLength());
		try{
		Sender sender = new Sender("AIzaSyBL5mt24Xx3Qw-yrhcewR-w6uD0shSs3pU"); //GOD Server API Key For Cloud Messagging
		Message message = new Message.Builder().build();
		List<String> devices = new RegisterDevice().getActiveCustomers();
		logger.info("Fetched devices "+devices.size());
		MulticastResult result = sender.send(message, devices , 5);

		logger.info(result);
		response.getWriter().print(result);
		response.getWriter().print(result.getCanonicalIds());
		logger.info(result.getCanonicalIds());
		response.getWriter().print(result.getResults().toArray());
		logger.info(result.getResults().toArray());
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getStackTrace()); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
