package com.camel.ApacheCamel.controller;

import com.camel.ApacheCamel.model.LibraryBookDetail;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    @Produce(uri = "direct:restPointCall")
    private ProducerTemplate producerTemplate;

    /**
     *
     * @param serialNo
     * @param bookName
     * @param autherName
     * @param price
     * This call receive the Book Detail using rest call and forward it to rabbitMQ queue.
     * @return Simple message "Processed Successfully"
     */
    @GetMapping(value = "/enterbookdetail")
    public String enterBookDetailToLibrary(@RequestParam("serialNo") int serialNo, @RequestParam("bookName") String bookName, @RequestParam("autherName") String autherName, @RequestParam("price") Double price) {
        LibraryBookDetail bookDetail = LibraryBookDetail.builder().serialNo(serialNo)
                .bookName(bookName)
                .autherName(autherName)
                .price(price)
                .build();
        producerTemplate.asyncSendBody(producerTemplate.getDefaultEndpoint(), bookDetail);
        return "Processed Successfully";
    }
}
