/**
 * 
 */
package services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* === 🌌 WELCOME TO ORBIT VIEW RENDERER 🌌  ===
*                     
*	  By :
*
*     ██████╗ ██████╗ ██████╗ ██╗████████╗    ████████╗██╗   ██╗██████╗ ███╗   ██╗███████╗██████╗ 
*    ██╔═══██╗██╔══██╗██╔══██╗██║╚══██╔══╝    ╚══██╔══╝██║   ██║██╔══██╗████╗  ██║██╔════╝██╔══██╗
*    ██║   ██║██████╔╝██████╔╝██║   ██║          ██║   ██║   ██║██████╔╝██╔██╗ ██║█████╗  ██████╔╝
*    ██║   ██║██╔══██╗██╔══██╗██║   ██║          ██║   ██║   ██║██╔══██╗██║╚██╗██║██╔══╝  ██╔══██╗
*    ╚██████╔╝██║  ██║██████╔╝██║   ██║          ██║   ╚██████╔╝██║  ██║██║ ╚████║███████╗██║  ██║
*     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝   ╚═╝          ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝
*          
*  AUTHOR : MOHAMED GUEYE [Orbit Turner] - Linkedin: www.linkedin.com/in/orbitturner - Email: orbitturner@orbitturner.com - Country: Senegal
*                              GITHUB : Orbit Turner    -   Website: http://orbitturner.com/ 
*/
/**
 * @author shado Service to load a view more easily
 */
public class ViewRenderer {
    /**
     * Getting The Actual Project Layout Template
     * \/WEB-INF/view/template/OrbitLayout.jsp
     */
    private static final String THEME = UrlHelper.getTheme();

    /**
     * Render an View depending on :
     * 
     * @param currentClass
     * @param request
     * @param response
     * @param pageTitle
     * @param view
     * @throws ServletException
     * @throws IOException
     */
    public static void render( HttpServlet currentClass, HttpServletRequest request, HttpServletResponse response,
            String pageTitle, String view ) throws ServletException, IOException {

        request.setAttribute( "pageTitle", pageTitle );
        request.setAttribute( "view", view );

        currentClass.getServletContext().getRequestDispatcher( THEME ).forward( request, response );

    }

}
