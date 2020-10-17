package services;

/**
 * 
 * @author shado Helper that returs Resources repos for Maintenance and
 *         Reusability
 */
public class UrlHelper {
    private static String project_base = "http://localhost:8080/SenForage_JSP_Servlet_1/";

    /**
     * Resources BaseUrl Repository
     * 
     * @return String
     */
    public static String getResourcesRepos() {
        return project_base + "resources/";
    }

    /**
     * CSS Repository
     * 
     * @return String
     */
    public static String getCssRepos() {
        return project_base + "resources/css/";
    }

    /**
     * JS Repository
     * 
     * @return String
     */
    public static String getJsRepos() {
        return project_base + "resources/js/";
    }

    /**
     * Image Repository
     * 
     * @return String
     */
    public static String getImgRepos() {
        return project_base + "resources/images/";
    }

    /**
     * Assets Repository
     * 
     * @return String
     */
    public static String getAssetsRepos() {
        return project_base + "resources/assets/";
    }

    /**
     * Defines The Project Global Theme Layout
     * 
     * @return String
     */
    public static String getTheme() {
        return "/WEB-INF/view/template/OrbitLayout.jsp";
    }
}