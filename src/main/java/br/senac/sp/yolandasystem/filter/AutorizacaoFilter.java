package br.senac.sp.yolandasystem.filter;

import br.senac.sp.yolandasystem.entidade.Usuario;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutorizacaoFilter implements Filter {

    private static final boolean debug = true;

    private FilterConfig filterConfig = null;

    public AutorizacaoFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        //PASSO 1 - VERIFICAR SE O USUÁRIO ESTÁ LOGADO
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("usuario") == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");

        } else {
            //PASSO 2 - VERIFICAR SE O USUÁRIO POSSUI PERMISSÃO AO MÓDULO
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            String url = httpServletRequest.getRequestURI();
            String method = httpServletRequest.getMethod();
            //CHAMA A FUNÇÃO
            if (verificarAcessoNegado(url, usuario, method)) {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/naoAutorizado.jsp");
            }

        }
    }

    //FUNÇÃO PARA RESTRINGIR O USUÁRIO DE ACESSAR MÓDULOS
    //EXEMPLO: SE A URL CONTER /protegido/gerente, E O USUÁRIO NAO FOR UM GERENTE, VAI DAR ACESSO NEGADO
    public boolean verificarAcessoNegado(String url, Usuario usuario, String method) {
        System.out.println("method " + method);
        boolean naoOk = true;
        if (url.contains("/protegido/index") && (usuario.isVendedor() || usuario.isGerente() || usuario.isTI() || usuario.isAdministrador())) {
            naoOk = false;
        } else if (url.contains("/protegido/RelatorioServlet") && (usuario.isGerente() || usuario.isAdministrador())) {
            naoOk = false;
        } else if (url.contains("/protegido/ClientesVendasServlet") && (usuario.isVendedor() || usuario.isAdministrador())) {
            naoOk = false;
        }else if (url.contains("/protegido/ClientesVendasServlet") && method.equalsIgnoreCase("POST") || (usuario.isVendedor()|| usuario.isAdministrador())) {
            naoOk = false;
        } else if (url.contains("/protegido/ClientesServlet") && (usuario.isTI() || usuario.isAdministrador())) {
            naoOk = false;
        } else if (url.contains("/protegido/ProdutosServlet") && (usuario.isRetaguarda() || usuario.isAdministrador())) {
            naoOk = false;
        } else if (url.contains("/protegido/ProdutosServlet") && method.equalsIgnoreCase("POST")) {
            naoOk = false;
        } else if (url.contains(".js")) {
            naoOk = false;
        }
        return naoOk;

    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("AutorizacaoFilter:doFilter()");
        }

        doBeforeProcessing(request, response);

        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("AutorizacaoFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AutorizacaoFilter()");
        }
        StringBuffer sb = new StringBuffer("AutorizacaoFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
