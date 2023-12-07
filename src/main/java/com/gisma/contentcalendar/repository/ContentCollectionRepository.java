package com.gisma.contentcalendar.repository;

import com.gisma.contentcalendar.model.Content;
import com.gisma.contentcalendar.model.Status;
import com.gisma.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository
{
    private final List<Content> contentList = new ArrayList<>();


    public ContentCollectionRepository()
    {

    }

    public List<Content> findAll()
    {
        return contentList;
    }


    public Optional<Content> findById(Integer id)
    {
        return contentList.stream()
                .filter(c -> c.id().equals(id)).findFirst();
    }


    public void save(Content content)
    {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean existsById(Integer id)
    {
        return contentList
                .stream()
                .filter(content -> content.id()
                        .equals(id)).count() == 1;
    }


    public void deleteBydId(Integer id)
    {
        contentList.removeIf(c -> c.id().equals(id));
    }


    @PostConstruct
    private void init()
    {
        Content content = Content.builder()
                .id(1)
                .title("My First Blog Post")
                .desc("My First Blog Post")
                .status(Status.IDEA)
                .contentType(Type.ARTICLE)
                .dateCreated(LocalDateTime.now())
                .dateUpdated(null)
                .url("")
                .build();

        contentList.add(content);
    }


}
