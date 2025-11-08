package com.yl.paperservice.utils;

import com.yl.paperservice.dto.PaperDTO;
import com.yl.paperservice.dto.SearchTaskDTO;
import com.yl.paperservice.entity.SearchTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import reactor.core.publisher.Flux;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.print.Paper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yl
 * @date 2025-11-07 18:03
 */
@Component
public class ArxivParser {
    private static final Logger logger = LoggerFactory.getLogger(ArxivParser.class);

    public String getText(Element parent, String tag){
        NodeList nodes = parent.getElementsByTagName(tag);
        return (nodes.getLength() > 0 ? nodes.item(0).getTextContent().trim() : null);
    }
    public PaperDTO parseEntry(Element entry) {
        PaperDTO paper = new PaperDTO();
        paper.setId(getText(entry, "id"));
        paper.setTitle(getText(entry, "title"));
        paper.setSummary(getText(entry, "summary"));
        paper.setPublished(getText(entry, "published"));
        paper.setUpdated(getText(entry, "updated"));

        List<String> authors = new ArrayList<>();
        NodeList authorNodes = entry.getElementsByTagName("author");
        for (int i = 0; i < authorNodes.getLength(); i++) {
            Element author = (Element) authorNodes.item(i);
            authors.add(getText(author, "name"));
        }

        paper.setAuthors(authors);
        paper.setPdfLink(findPdfLink(entry));
        paper.setCategories(findCategories(entry));

        paper.setDoi(getText(entry, "arxiv:doi"));
        paper.setComment(getText(entry, "arxiv:comment"));
        paper.setJournalRef(getText(entry, "arxiv:journal_ref"));

        return paper;
    }

    public List<String> findCategories(Element entry) {
        List<String> categories = new ArrayList<>();
        NodeList categoryNode = entry.getElementsByTagName("category");
        for (int i = 0; i < categoryNode.getLength(); i++) {
            Element category = (Element) categoryNode.item(i);
            categories.add(category.getAttribute("term"));
        }
        return categories;
    }

    public String findPdfLink(Element entry) {
        NodeList links = entry.getElementsByTagName("link");
        for (int i = 0; i < links.getLength(); i++) {
            Element link = (Element) links.item(i);
            if("pdf".equals(link.getAttribute("title"))){
                return link.getAttribute("href");
            }
        }
        return null;
    }

    public Flux<PaperDTO> parse(String xml) {
        List<PaperDTO> papers = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true); // ✅ 启用命名空间解析
            Document doc = factory.newDocumentBuilder()
                    .parse(new InputSource(new StringReader(xml)));

            NodeList entries = doc.getElementsByTagName("entry");
            for (int i = 0; i < entries.getLength(); i++) {
                Element entry = (Element) entries.item(i);
                papers.add(parseEntry(entry));
            }
        } catch (Exception e) {
            logger.error("XML解析失败: {}", e.getMessage());
        }
        return Flux.fromIterable(papers);
    }
}
