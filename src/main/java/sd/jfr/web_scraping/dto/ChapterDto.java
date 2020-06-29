package sd.jfr.web_scraping.dto;

public class ChapterDto {
    private String chapterLink;
    private String chapterHtmlPageContent;

    public String getChapterLink() {
        return chapterLink;
    }

    public void setChapterLink(String chapterLink) {
        this.chapterLink = chapterLink;
    }

    public String getChapterHtmlPageContent() {
        return chapterHtmlPageContent;
    }

    public void setChapterHtmlPageContent(String chapterHtmlPageContent) {
        this.chapterHtmlPageContent = chapterHtmlPageContent;
    }
}
