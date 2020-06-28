/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd.jfr.web_scraping.dto;

/**
 *
 * @author LEGION
 */
public class CourseDto {
     private String courseLink;
     private String htmlPageContent;

    public String getCourseLink() {
        return courseLink;
    }

    public void setCourseLink(String courseLink) {
        this.courseLink = courseLink;
    }

    public String getHtmlPageContent() {
        return htmlPageContent;
    }

    public void setHtmlPageContent(String htmlPageContent) {
        this.htmlPageContent = htmlPageContent;
    }
    
     
     
    
}
