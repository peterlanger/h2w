package com.mkyong.common.controller;

import Hw8.HRVAS_2_web_v2;
import com.mathworks.toolbox.javabuilder.MWJavaObjectRef;
import com.mathworks.toolbox.javabuilder.webfigures.*;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class HelloWorldController  {


        private static final String uploadingdir = System.getProperty("user.dir") + "/";

        
    
        @RequestMapping(value = "/welcome.htm")
	protected String handle(HttpServletRequest request, Model model,
			HttpServletResponse response) throws Exception {
                
                
                HttpSession session = request.getSession();            
                                

		File file = new File(uploadingdir);
                
                model.addAttribute("files", file.listFiles());
                                        
                System.out.println(file.toString());
		model.addAttribute("message", file.toString());

                return "HelloWorldPage";
	}

        @RequestMapping(value = "/upload.form", method = RequestMethod.POST)
	protected String handleRequestInternal(@RequestParam("file") MultipartFile file, Model model, HttpServletRequest request) throws Exception {
                
            String file_name_and_path = uploadingdir + file.getOriginalFilename();
            File file2 = new File(file_name_and_path);
            file.transferTo(file2);
            
                System.out.println(file_name_and_path);
                System.out.println("You're big!");
             
                HttpSession session = request.getSession();       
                
                HRVAS_2_web_v2 hrvas;                  
                
                WebFigure obrazek= (WebFigure)session.getAttribute("obrazek");
                WebFigure obrazek1 = (WebFigure)session.getAttribute("obrazek1");
                WebFigure obrazek2=(WebFigure)session.getAttribute("obrazek2");
                WebFigure obrazek3=(WebFigure)session.getAttribute("obrazek3");
                

                hrvas = new HRVAS_2_web_v2();

               
                Object[] result = hrvas.HRVAS_Langer_v3(5,file_name_and_path,"matlab smooth");
                MWJavaObjectRef ref;
                
                ref = (MWJavaObjectRef)result[0];
                obrazek = (WebFigure)ref.get();
                session.setAttribute("obrazek", obrazek);
                ref = (MWJavaObjectRef)result[1];
                obrazek1 = (WebFigure)ref.get();
                session.setAttribute("obrazek1", obrazek1);
                ref = (MWJavaObjectRef)result[2];
                obrazek2 = (WebFigure)ref.get();
                session.setAttribute("obrazek2", obrazek2);
                ref = (MWJavaObjectRef)result[3];
                obrazek3 = (WebFigure)ref.get();
                session.setAttribute("obrazek3", obrazek3);     

                WebFigureHtmlGenerator webFigures;
                webFigures = new WebFigureHtmlGenerator(request);
                
                String webFig = webFigures.getFigureEmbedString(obrazek,"obrazek", "session", "300", "300", "");
                String webFig1 = webFigures.getFigureEmbedString(obrazek1,"obrazek1", "session", "300", "300", "");
                String webFig2 = webFigures.getFigureEmbedString(obrazek2,"obrazek2", "session", "300", "300", "");
                String webFig3 = webFigures.getFigureEmbedString(obrazek3,"obrazek3", "session", "300", "300", "");
                
                model.addAttribute("webFig", webFig);
                model.addAttribute("webFig1", webFig1);
                model.addAttribute("webFig2", webFig2);
                model.addAttribute("webFig3", webFig3);
              
		model.addAttribute("msg", "hello world");
                


		return "HelloWorldPage";
        }        
}