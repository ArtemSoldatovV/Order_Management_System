package Client;


import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class ClientDTO {

    @NotNull(message = "Идентификатор (id) не может быть пустым")
    private Long id;


    @NotBlank(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 50, message = "Имя должно содержать от 2 до 50 символов")
    private String name;

    @NotBlank(message = "Фамилия не должно быть пустым")
    @Size(min = 2, max = 50, message = "Фамилия должно содержать от 2 до 50 символов")
    private String surname;

    private String patronymic;

    @NotNull(message = "пароль не может быть пустым")
    private String password;

    @NotBlank(message = "Email не должен быть пустым")
    @Email(message = "Некорректный email")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Номер телефона должен содержать 10 цифр")
    private String phone;

    @NotNull(message = "дата регистрации не может быть пустой")
    private String registration_date;

    @NotNull(message = "Возраст не должен быть пустым")
    @Min(value = 0, message = "Возраст не может быть отрицательным")
    @Max(value = 120, message = "Возраст не может превышать 120 лет")
    private Integer age;

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
