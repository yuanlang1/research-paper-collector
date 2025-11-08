package com.yl.paperservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

/**
 * @author yl
 * @date 2025-11-06 21:22
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaperDTO {
    private String id;
    private String title;
    private String summary;
    private String published;
    private String updated;
    private List<String> authors;
    private String pdfLink;
    private String doi;
    private String comment;
    private String journalRef;
    private List<String> categories;
}


