package masterfila.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class AutenticacaoInscrito
 */
@WebFilter("/AutenticacaoInscrito")
public class InscritoFiltro implements Filter {

    /**
     * Default constructor. 
     */
    public InscritoFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession sessao = req.getSession();
		
//		try{
//			Inscrito inscritoAutenticado = (Inscrito) sessao.getAttribute("inscrito_autenticado");
//			
//			if(inscritoAutenticado!=null){
//				chain.doFilter(request, response);			
//			}else{
//				resp.sendRedirect("../index.jsp");
//			}			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
