package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }


  @Override
  public void run(String... args) throws Exception {

    //add the publiser
    Publisher publisher = new Publisher();
    publisher.setPublisherName("Microsoft Publisher");
    publisher.setPublisherAddress("some address");
    publisher.setPublisherZip("45645");
    publisher.setPublisherState("Jalisco");

    Publisher publisherSaved = publisherRepository.save(publisher);

    //authors
    Author eric = new Author();
    eric.setFirstName("Eric");
    eric.setLastName("Evants");

    Author rod = new Author();
    rod.setFirstName("Rod");
    rod.setLastName("Johnson");


    //books
    Book ddd = new Book();
    ddd.setTitle("Domain Drive Design");
    ddd.setIsbn("1234567890");

    Book noEJB = new Book();
    noEJB.setTitle("J2EE Development without EJB");
    noEJB.setIsbn("567890");


    //save the books and authors
    Author erickSaved = authorRepository.save(eric);
    Author rodSaved = authorRepository.save(rod);
    Book dddSaved = bookRepository.save(ddd);
    Book noEJBSaved = bookRepository.save(noEJB);

    //set publiser relationshhip
    dddSaved.setPublisher(publisherSaved);
    noEJBSaved.setPublisher(publisherSaved);

    //create the associations between books and authors
    erickSaved.getBooks().add(dddSaved);
    rodSaved.getBooks().add(noEJBSaved);
    dddSaved.getAuthors().add(erickSaved);
    noEJBSaved.getAuthors().add(rodSaved);


    authorRepository.save(erickSaved);
    authorRepository.save(rodSaved);
    bookRepository.save(dddSaved);
    bookRepository.save(noEJBSaved);

    System.out.println("In BootstrapData .............................................");
    System.out.println("Author count: " + authorRepository.count());
    System.out.println("Book count: " + bookRepository.count());
    System.out.println("Publisher count: " + publisherRepository.count());

  }
}
