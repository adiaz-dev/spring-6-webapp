package guru.springframework.spring6webapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String publisherName;
  private String publisherAddress;
  private String publisherCity;
  private String publisherState;
  private String publisherZip;

  @OneToMany(mappedBy = "publisher")
  private Set<Book> books;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  public String getPublisherAddress() {
    return publisherAddress;
  }

  public void setPublisherAddress(String publisherAddress) {
    this.publisherAddress = publisherAddress;
  }

  public String getPublisherCity() {
    return publisherCity;
  }

  public void setPublisherCity(String publisherCity) {
    this.publisherCity = publisherCity;
  }

  public String getPublisherState() {
    return publisherState;
  }

  public void setPublisherState(String publisherState) {
    this.publisherState = publisherState;
  }

  public String getPublisherZip() {
    return publisherZip;
  }

  public void setPublisherZip(String publisherZip) {
    this.publisherZip = publisherZip;
  }

  @Override
  public final boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Publisher publisher)) {
      return false;
    }

    return Objects.equals(getId(), publisher.getId()) && Objects.equals(
        getPublisherName(), publisher.getPublisherName()) && Objects.equals(
        getPublisherAddress(), publisher.getPublisherAddress()) && Objects.equals(
        getPublisherCity(), publisher.getPublisherCity()) && Objects.equals(
        getPublisherState(), publisher.getPublisherState()) && Objects.equals(
        getPublisherZip(), publisher.getPublisherZip());
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(getId());
    result = 31 * result + Objects.hashCode(getPublisherName());
    result = 31 * result + Objects.hashCode(getPublisherAddress());
    result = 31 * result + Objects.hashCode(getPublisherCity());
    result = 31 * result + Objects.hashCode(getPublisherState());
    result = 31 * result + Objects.hashCode(getPublisherZip());
    return result;
  }

  @Override
  public String toString() {
    return "Publisher{" +
        "id=" + id +
        ", publisherName='" + publisherName + '\'' +
        ", publisherAddress='" + publisherAddress + '\'' +
        ", publisherCity='" + publisherCity + '\'' +
        ", publisherState='" + publisherState + '\'' +
        ", publisherZip='" + publisherZip + '\'' +
        '}';
  }
}
