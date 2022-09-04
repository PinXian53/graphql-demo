package com.example.graphql_demo.dao;

import com.example.graphql_demo.model.CreateBookInput;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
public class Book {

    private String id;
    private String name;
    private String authorId;
    private Integer pageCount;
    private String publicationDate;
    private String description;

    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("9dc8e3f0-3358-419f-9b81-09c46f7151d8", "射鵰英雄傳",
            "96b5b8f1-9be5-4a50-a20f-5a2dd87f2062", 918, "1957/01/01",
            "本書以南宋寧宗慶元五年至嘉定十四年間作為背景，以靖康之變為郭靖與楊康取名。 少年郭靖為人樸實且善良，父親郭嘯天在他年幼時遭人殺害而亡，使他燃起了報仇之心。 在這期間，因江南七怪成為他的師父。"));
        books.add(new Book("455f0764-2354-4604-b0e3-22c306530715", "神鵰俠侶",
            "96b5b8f1-9be5-4a50-a20f-5a2dd87f2062", 979, "1959/05/20",
            "小説的主脈寫的是楊康之遺孤楊過與其師小龍女之間的愛情故事。楊過14歲起師從18歲的小龍女，於古墓派之中苦練武功，師徒二人情深義重、日久生情，卻無奈於江湖陰鷙險惡、蒙古鐵騎來犯使得有情之人難成眷屬。"));
        books.add(new Book("d54c639e-b846-4a9a-adf8-0bd55eee223d", "倚天屠龍記",
            "96b5b8f1-9be5-4a50-a20f-5a2dd87f2062", 956, "1961/07/06",
            "以安徽農民朱元璋揭竿而起建立明朝天下為背景，以張無忌的成長為線索，敍寫江湖上的各幫各派、各種人物的恩怨情仇，它把中國歷史上元朝的興衰和江湖道義、恩仇平行交叉起來。該書表達了作者既反對異族侵略，也反對本民族暴政的思想。"));
        books.add(new Book("c63c09d7-4a48-4b7c-a1e5-d26932309f11", "背影", "d989a4d2-e6de-4626-9f6f-f43f9d8e4032", 1,
            "1925/01/01",
            "一地散落的朱紅橘子，一個父親的蹣跚背影經典文學融合優美插畫，生動呈現父愛的形象散文大家朱自清將深厚的情感，寄託於樸實的景物描寫"));
        books.add(new Book("4c88dec6-fa58-4d5c-b2f1-913d239ec68f", "傾城之戀",
            "588ba158-afa9-4d9e-af61-944dc6532736", 223, "20221",
            "《傾城之戀》集結張愛玲橫空出世、震撼文壇的八篇短篇小說代表作，有著她對人性尖銳的剖析，折射出世間男女的愛嗔欲求、苦恨毒辣。她寶愛街巷裡流麗的熱鬧，流連城市中的聲光氣味，念舊又貪新；卻每每在華美處，以剔透之心體察出蒼涼悲意。舉重若輕的情節流轉，曖昧繁複的心理周折，寫盡人們生於浮世危城的瘋癡和抑鬱、徒勞和惘然。一爐沉香，一壺香片，一輪冷月，她用文字挽住了一個時代，也帶我們走進那沒有光的所在。"));
    }

    public static List<Book> getAll() {
        return books;
    }

    public static Book getById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public static List<Book> findByAuthorId(String authorId) {
        return books.stream().filter(book -> book.getAuthorId().equals(authorId)).collect(Collectors.toList());
    }

    public static Book createBook(CreateBookInput input) {
        final Book book = new Book(UUID.randomUUID().toString(), input.getName(), input.getAuthorId(),
            input.getPageCount(), input.getPublicationDate(), input.getDescription());
        books.add(book);
        return book;
    }
}