package com.camel.ApacheCamel.model;

import lombok.*;

/**
 * Model class to Process the Library Book details.
 *
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryBookDetail {
    private int serialNo;
    private String bookName;
    private String autherName;
    private double price;
}
