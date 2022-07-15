package ojbv.identity.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Book")
@RestController 
@RequestMapping(path = "api/book")
public class BookApi {
    
    @RolesAllowed(Role.BOOK_ADMIN)
    @PostMapping
    public BookView create() { }

    @RolesAllowed(Role.BOOK_ADMIN)
    @PutMapping("{id}")
    public void edit() { }

    @RolesAllowed(Role.BOOK_ADMIN)
    @DeleteMapping("{id}")
    public void delete() { }

    @GetMapping("{id}")
    public void get() { }

    @GetMapping("{id}/author")
    public void getAuthors() { }

    @PostMapping("search")
    public void search() { }
}
