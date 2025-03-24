package User;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class UserDTO {

    @NotNull(message = "Идентификатор (id) не может быть пустым")
    private Long id;

    @NotNull(message = "имя не может быть пустым")
    private String name;

    private String surname;

    private String patronymic;

    @NotNull(message = "пароль не может быть пустым")
    private String password;

    @NotNull(message = "электронная почта не может быть пустым")
    private String email;

    @NotNull(message = "телефон не может быть пустым")
    private String phone;

    @NotNull(message = "должность не может быть пустой")
    private String post;

    @NotNull(message = "дата регистрации не может быть пустой")
    private String registration_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }
}
