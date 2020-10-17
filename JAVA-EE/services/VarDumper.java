/**
 * 
 */
package services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

/* === 🌌 WELCOME TO ORBIT JEE REMIX 🌌  ===
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
 * @author shado Used For debug Purpose to expose everything in a Variable out
 */
public class VarDumper {

    public static void vardump( HttpServletResponse response, Object objet ) throws ServletException, IOException {
        response.setContentType( "text/html;charset=UTF-8" );
        response.getWriter()
                .append( "\n<h1>==== TYPE DE LA VARIABLE ====</h1>\n" + "⮕ " + objet.getClass() )
                .append( "\n\n<h1>==== CONTENU DE LA VARIABLE/OBJET ====</h1>\n" )
                .append( "⮕ " + String.valueOf( objet ) )
                .append( "\n\n<h1>==== TOSTRING() CONTENT  ====</h1>\n⮕ " + objet.toString() );
    }
}
