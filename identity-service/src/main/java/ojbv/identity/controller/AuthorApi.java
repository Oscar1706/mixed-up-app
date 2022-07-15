package ojbv.identity.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Author")
@RestController
@RequestMapping(path = "api/author")
public class AuthorApi {
    
    @RolesAllowed(Role.AUTHOR_ADMIN)
    @PostMapping
    public void create() {}

    @RolesAllowed(Role.AUTHOR_ADMIN)
    @PutMapping("{id}")
    public void edit() {}

    @RolesAllowed(Role.AUTHOR_ADMIN)
    @DeleteMapping("{id}")
    public void delete() {}

    @GetMapping("{id}")
    public void get() {}

    @GetMapping("{id}/book")
    public void getBooks() {}

    @PostMapping("search")
    public void search() {}
}
