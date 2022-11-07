package dk.jplm.grpc.client.clientservice.controller;

import com.google.protobuf.Descriptors;
import dk.jplm.grpc.client.clientservice.service.BookAuthorClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BookAuthorController {

    BookAuthorClientService service;

    @GetMapping("author/{authorId}")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable String authorId) {
        return service.getAuthor(Integer.parseInt(authorId));
    }

    @GetMapping("book/{authorId}")
    public List<Map<Descriptors.FieldDescriptor, Object>> getBooksByAuthor(@PathVariable String authorId) throws InterruptedException {
        return service.getBooksByAuthor(Integer.parseInt(authorId));
    }

    @GetMapping("/book")
    public Map<String, Map<Descriptors.FieldDescriptor, Object>> getExpensiveBook() throws InterruptedException {
        return service.getExpensiveBook();
    }

    @GetMapping("book/author/{gender}")
    public List<Map<Descriptors.FieldDescriptor, Object>> getBooksByAuthorGender(@PathVariable String gender) throws InterruptedException {
        return service.getBooksByAuthorGender(gender);
    }
}
