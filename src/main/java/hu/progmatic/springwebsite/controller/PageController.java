package hu.progmatic.springwebsite.controller;


import hu.progmatic.springwebsite.model.Book;
import hu.progmatic.springwebsite.model.User;
import hu.progmatic.springwebsite.service.BookService;
import hu.progmatic.springwebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public PageController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping({"/", "/home"})
    public String index() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "bookList";
    }

    @GetMapping("/add-book")
    public String showAddBookForm(Model model) {
        model.addAttribute("newBook", new Book());
        return "addBook";
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute("newBook") Book newBook) {
        bookService.addBook(newBook);
        return "redirect:/books";
    }

    @GetMapping("/add-user")
    public String showAddUserFrom(Model model) {
        model.addAttribute("newUser", new User());
        return  "addUser";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("new User") User newUser){
        userService.addUser(newUser);
        return  "redirect:/users";
    }

}